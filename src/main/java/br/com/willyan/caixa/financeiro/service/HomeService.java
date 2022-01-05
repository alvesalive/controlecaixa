package br.com.willyan.caixa.financeiro.service;

import br.com.willyan.caixa.financeiro.model.Movimentacao;
import br.com.willyan.caixa.financeiro.repository.CaixaRepository;
import br.com.willyan.caixa.financeiro.repository.MovimentacaoRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Getter
@Setter
public class HomeService {

    private Long ano;
    private Long mes;
    private String caixa;


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

    // TODO - FIX <------------------------------------
    public Number[] entradaSaidaMesAtual() {
        Number[] valores = new Number[3];

        var lambdaContext = new Object() {
            Double entradas = Double.valueOf(0);
            Double saidas = Double.valueOf(0);
        };

        /** ATENÇÃO : popular com metodo correto (find1, 2 ou 3)  * */

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




    // TODO implementar find1
    public List<Movimentacao> findMovimentacaoByAno(long ano) {

        /* Ano do parametro + Caixa Atual + mes atual */
        //return movimentacaoRepository.findMovimentacaoByData_YearAndData_MonthAndCaixa(ano, mes, caixa);

        return new ArrayList<>();
    }


    // TODO implementar find2
    public List<Optional<Movimentacao>> findMovimentacaoByMes(long mes) {

        /* Ano Atual + Caixa Atual + Movimentacoes com Mes do parametro */
        //return movimentacaoRepository.findMovimentacaoByData_YearAndData_MonthAndCaixa(ano, mes, caixa);

         return new ArrayList<>();
    }


    // TODO implementar find3
    public List<Optional<Movimentacao>> findMovimentacaoByCaixa(long caixaId) {

        /* Ano corrente + Mes Corrente + Movimentacoes com caixa = caixaID */
        //return movimentacaoRepository.findMovimentacaoByData_YearAndData_MonthAndCaixa(ano, mes, caixa);

        return new ArrayList<>();
    }

}