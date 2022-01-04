package br.com.willyan.caixa.financeiro.controller;

import br.com.willyan.caixa.financeiro.repository.MovimentacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @Autowired
    private MovimentacaoRepository movimentacaoRepository;

    @GetMapping("/")
    public String movimentacaoes(Model model){
        model.addAttribute("listaMovimentacoes", movimentacaoRepository.findAll());
        return "index";
    }

}
