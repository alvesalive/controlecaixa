package br.com.willyan.caixa.financeiro.controller;


import br.com.willyan.caixa.financeiro.model.Movimentacao;
import br.com.willyan.caixa.financeiro.repository.CaixaRepository;
import br.com.willyan.caixa.financeiro.repository.MovimentacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class MovimentacaoController {
    @Autowired
    private MovimentacaoRepository movimentacaoRepository;

    @Autowired
    private CaixaRepository caixaRepository;

    @GetMapping("/movimentacoes")
    public String movimentacaoes(Model model){
        model.addAttribute("listaMovimentacoes", movimentacaoRepository.findAll());
        return "movimentacoes/index";
    }

    @GetMapping("movimentacoes/nova")
    public String novaMovimentacao(Model model){
        model.addAttribute("movimentacao", new Movimentacao(null,"",""));
        model.addAttribute("caixas", caixaRepository.findAll());

        return "movimentacoes/formulario";
    }

    @GetMapping("movimentacoes/{id}")
    public String alterarMovimentacao(@PathVariable("id") long id, Model model){
        Optional<Movimentacao> movimentacaoOptional = movimentacaoRepository.findById(id);

        if (movimentacaoOptional.isEmpty()){
            throw new IllegalArgumentException("movimentação inválida.");
        }
        model.addAttribute("movimentacao", movimentacaoOptional.get());
        model.addAttribute("caixas", caixaRepository.findAll());
        return "movimentacoes/formulario";
    }

    @GetMapping("/movimentacoes/apagar/{id}")
    public String excluirCaixa(@PathVariable("id") long id){
        Optional<Movimentacao> movimentacaoOptional = movimentacaoRepository.findById(id);

        if (movimentacaoOptional.isEmpty()){
            throw new IllegalArgumentException("movimentação inválida.");
        }
        movimentacaoRepository.delete(movimentacaoOptional.get());
        return "redirect:/movimentacoes";

    }

    @PostMapping("movimentacoes/salvar")
    public String salvarMovimentacao(@Valid @ModelAttribute("movimentacao") Movimentacao movimentacao, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("caixas", caixaRepository.findAll());
            return "movimentacoes/formulario";
        }

        movimentacaoRepository.save(movimentacao);
        return "redirect:/movimentacoes";
    }


}
