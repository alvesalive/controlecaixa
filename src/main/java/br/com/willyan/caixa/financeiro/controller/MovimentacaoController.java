package br.com.willyan.caixa.financeiro.controller;

import br.com.willyan.caixa.financeiro.model.Caixa;
import br.com.willyan.caixa.financeiro.model.Movimentacao;
import br.com.willyan.caixa.financeiro.repository.MovimentacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MovimentacaoController {
    @Autowired
    private MovimentacaoRepository movimentacaoRepository;

    @GetMapping("/movimentacoes")
    public String movimentacaoes(Model model){
        model.addAttribute("listaMovimentacoes", movimentacaoRepository.findAll());
        return "movimentacoes/index";
    }

    @GetMapping("movimentacoes/nova")
    public String novaMovimentacao(@ModelAttribute("movimentacao") Movimentacao movimentacao){
        return "movimentacoes/formulario";
    }

    @PostMapping("movimentacoes/salvar")
    public String salvarMovimentacao(@ModelAttribute("movimentacao") Movimentacao movimentacao){
        movimentacaoRepository.save(movimentacao);
        return "redirect:/movimentacoes";
    }


}
