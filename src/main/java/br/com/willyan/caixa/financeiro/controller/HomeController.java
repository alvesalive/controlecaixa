package br.com.willyan.caixa.financeiro.controller;

import br.com.willyan.caixa.financeiro.model.Caixa;
import br.com.willyan.caixa.financeiro.model.Movimentacao;
import br.com.willyan.caixa.financeiro.repository.CaixaRepository;
import br.com.willyan.caixa.financeiro.repository.MovimentacaoRepository;
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

    @GetMapping("/")
    public String movimentacaoes(Model model){
        model.addAttribute("listaMovimentacoes", movimentacaoRepository.findAll());
        model.addAttribute("caixas", caixaRepository.findAll());
        return "index";
    }

    //TODO FIX
//    @GetMapping("/find")
//    public String movJan(Model model){
//        model.addAttribute("listaMovimentacoes", movimentacaoRepository.findByData());
//        return "index";
//    }

    @GetMapping ("/mes/{ano}")
    public String findByAno(@PathVariable long ano, Model model){
        //Optional<Movimentacao> movimentacaoOptional = movimentacaoRepository.findById(ano);
//        List<Movimentacao> movimentacaoOptional = movimentacaoRepository.findAll();
//        if (movimentacaoOptional.isEmpty()){
//            throw new IllegalArgumentException("sem movimentação.");
//        }
//        model.addAttribute("movimentacao", movimentacaoOptional.add(0,);

        return "index";

    }



}
