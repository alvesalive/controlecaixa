package br.com.willyan.caixa.financeiro.repository;

import br.com.willyan.caixa.financeiro.model.Movimentacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Long> {


//List<Movimentacao> findMovimentacaoByData_YearAndData_MonthAndCaixa(Long ano, long mes, String caixa);



}
