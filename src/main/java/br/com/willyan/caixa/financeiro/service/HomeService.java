package br.com.willyan.caixa.financeiro.service;

import br.com.willyan.caixa.financeiro.model.Caixa;
import br.com.willyan.caixa.financeiro.model.Movimentacao;
import br.com.willyan.caixa.financeiro.repository.CaixaRepository;
import br.com.willyan.caixa.financeiro.repository.MovimentacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HomeService {

    @Autowired
    private CaixaRepository caixaRepository;

    @Autowired
    private MovimentacaoRepository movimentacaoRepository;

    public List<Movimentacao> findMovimentacao() {
        List<Movimentacao> movimentacaoList = new ArrayList<>();
        movimentacaoList.addAll(movimentacaoRepository.findAll());
        return movimentacaoList;
    }

    public List<Optional<Movimentacao>> findMovimentacaoByAno(long ano) {
        List<Optional<Movimentacao>> movimentacaoList = new ArrayList<>();
        if (movimentacaoList.isEmpty()) {
            return new ArrayList<>();
        }
        //movimentacaoList.add(movimentacaoRepository.findBy( /* Ano do Parametro + Mes Corrente + Caixa atual */ ));
        return movimentacaoList;
    }


    public List<Optional<Movimentacao>> findMovimentacaoByMes(long mes) {
        List<Optional<Movimentacao>> movimentacaoList = new ArrayList<>();
        if (movimentacaoList.isEmpty()) {
            return new ArrayList<>();
        }
        //movimentacaoList.add(movimentacaoRepository.findBy( /* Ano Atual + Caixa Atual + Movimentacoes com Mes do parametro / ));
        return movimentacaoList;
    }


    public List<Optional<Movimentacao>> findMovimentacaoByCaixa(long caixaId) {
        List<Optional<Movimentacao>> movimentacaoList = new ArrayList<>();
        if (movimentacaoList.isEmpty()) {
            return new ArrayList<>();
        }
        //movimentacaoList.add(movimentacaoRepository.findBy( /* Ano corrente + Mes Corrente + Movimentacoes com caixa = caixaID */ ));
        return movimentacaoList;
    }

}
