package br.com.willyan.caixa.financeiro.service;

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


    public Number[] balancoGeral() {
        Number[] valores = new Number[3];

        var lambdaContext = new Object() {
            Double entradas = Double.valueOf(0);
            Double saidas = Double.valueOf(0);
        };

        List<Movimentacao> movimentacaoList = new ArrayList<>(findMovimentacao());
        movimentacaoList.stream().forEach(
                movimentacao ->
                {
                    if (movimentacao.getTipo() == "Entrada") {
                        valores[0] = lambdaContext.entradas += movimentacao.getValor();
                    } else {
                        valores[1] = lambdaContext.saidas += movimentacao.getValor();
                    }
                }
        );
        valores[2] = valores[0].doubleValue() - valores[1].doubleValue();
        return valores;
    }


    //TODO - TO FIX <------------------------------------
    public Number[] entradaSaidaMesAtual() {
        Number[] valores = new Number[3];

        var lambdaContext = new Object() {
            Double entradas = Double.valueOf(0);
            Double saidas = Double.valueOf(0);
        };

        /*
         * ATENÇÃO
         * popular com metodo correto (find1, 2 ou 3)
         * */

        List<Movimentacao> movimentacaoList = new ArrayList<>(findMovimentacao());

        movimentacaoList.stream().forEach(
                movimentacao ->
                {
                    if (movimentacao.getTipo() == "Entrada") {
                        valores[0] = lambdaContext.entradas += movimentacao.getValor();
                    } else {
                        valores[1] = lambdaContext.saidas += movimentacao.getValor();
                    }
                }
        );
        valores[2] = valores[0].doubleValue() - valores[1].doubleValue();
        return valores;
    }


    //TODO implementar find1
    public List<Optional<Movimentacao>> findMovimentacaoByAno(long ano) {
        List<Optional<Movimentacao>> movimentacaoList = new ArrayList<>();
        if (movimentacaoList.isEmpty()) {
            return new ArrayList<>();
        }
        //movimentacaoList.add(movimentacaoRepository.findBy( /* Ano do Parametro + Mes Corrente + Caixa atual */ ));
        return movimentacaoList;
    }


    //TODO implementar find2
    public List<Optional<Movimentacao>> findMovimentacaoByMes(long mes) {
        List<Optional<Movimentacao>> movimentacaoList = new ArrayList<>();
        if (movimentacaoList.isEmpty()) {
            return new ArrayList<>();
        }
        //movimentacaoList.add(movimentacaoRepository.findBy( /* Ano Atual + Caixa Atual + Movimentacoes com Mes do parametro / ));
        return movimentacaoList;
    }


    //TODO implementar find3
    public List<Optional<Movimentacao>> findMovimentacaoByCaixa(long caixaId) {
        List<Optional<Movimentacao>> movimentacaoList = new ArrayList<>();
        if (movimentacaoList.isEmpty()) {
            return new ArrayList<>();
        }
        //movimentacaoList.add(movimentacaoRepository.findBy( /* Ano corrente + Mes Corrente + Movimentacoes com caixa = caixaID */ ));
        return movimentacaoList;
    }

}