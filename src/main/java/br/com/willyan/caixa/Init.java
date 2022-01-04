package br.com.willyan.caixa;

import br.com.willyan.caixa.financeiro.model.Caixa;
import br.com.willyan.caixa.financeiro.model.Movimentacao;
import br.com.willyan.caixa.financeiro.repository.CaixaRepository;
import br.com.willyan.caixa.financeiro.repository.MovimentacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class Init implements CommandLineRunner {

    @Autowired
    private MovimentacaoRepository movimentacaoRepository;

    @Autowired
    private CaixaRepository caixaRepository;


    @Override
    public void run(String... args) throws Exception {

        Caixa c1 = new Caixa("Conta Corrente Itau", 5000.00);
        Caixa c2 = new Caixa("Conta Corrente Santander", 99000.00);
        caixaRepository.save(c1);
        caixaRepository.save(c2);
        caixaRepository.flush();

        Movimentacao m1 = new Movimentacao(LocalDate.of(2022,1,4),"Entrada", "Freelance", 12500.00);
        Movimentacao m2 = new Movimentacao(LocalDate.of(2022,1,5),"Saída", "Energia", 350.00);
        m1.setCaixa(c1);
        m2.setCaixa(c2);

        movimentacaoRepository.save(m1);
        movimentacaoRepository.save(m2);

    }
}
