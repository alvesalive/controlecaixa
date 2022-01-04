package br.com.willyan.caixa.financeiro.controller;


import br.com.willyan.caixa.financeiro.model.Caixa;
import br.com.willyan.caixa.financeiro.repository.CaixaRepository;
import br.com.willyan.caixa.financeiro.repository.MovimentacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;


@Controller
public class CaixaController {

    @Autowired
    private CaixaRepository caixaRepository;

    @GetMapping("/caixas")
    public String caixas(Model model){
        model.addAttribute("listaCaixas", caixaRepository.findAll());
        return "caixas/index";
    }

    @GetMapping("caixas/nova")
    public String novaCaixa(@ModelAttribute("caixa") Caixa caixa){
        return "caixas/formulario";
    }

    @GetMapping("caixas/{id}")
    public String alterarCaixa(@PathVariable("id") long id, Model model){
        Optional<Caixa> caixaOptional = caixaRepository.findById(id);

        if (caixaOptional.isEmpty()){
            throw new IllegalArgumentException("conta inválida.");
        }
        model.addAttribute("caixa", caixaOptional.get());
        return "caixas/formulario";
    }

    @GetMapping("/caixas/apagar/{id}")
    public String excluirCaixa(@PathVariable("id") long id){
        Optional<Caixa> caixaOptional = caixaRepository.findById(id);

        if (caixaOptional.isEmpty()){
            throw new IllegalArgumentException("conta inválida.");
        }
        caixaRepository.delete(caixaOptional.get());
        return "redirect:/caixas";

    }


    @PostMapping("caixas/salvar")
    public String salvarCaixa(@ModelAttribute("caixa") Caixa caixa){
        caixaRepository.save(caixa);
        return "redirect:/caixas";
    }


}
