package br.com.willyan.caixa.financeiro.controller;

import br.com.willyan.caixa.financeiro.model.Caixa;
import br.com.willyan.caixa.financeiro.model.Movimentacao;
import br.com.willyan.caixa.financeiro.repository.CaixaRepository;
import br.com.willyan.caixa.financeiro.repository.MovimentacaoRepository;
import br.com.willyan.caixa.financeiro.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

@Controller
public class HomeController {
    @Autowired
    private MovimentacaoRepository movimentacaoRepository;

    @Autowired
    private CaixaRepository caixaRepository;

    @Autowired
    private HomeService homeService;

    @GetMapping("/")
    public String movimentacaoes(Model model){
        model.addAttribute("listaMovimentacoes", homeService.findMovimentacao());
        model.addAttribute("caixas", caixaRepository.findAll());
        model.addAttribute("entrSaid", homeService.entradaSaidaMesAtual());
        model.addAttribute("balGeral", homeService.balancoGeral());
        return "index";
    }



    @GetMapping ("/mes/{ano}")
    public String findByAno(@PathVariable long ano, Model model){
        model.addAttribute("listaMovimentacoes");

        return "index";

    }



}
