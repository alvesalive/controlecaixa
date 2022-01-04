package br.com.willyan.caixa.financeiro.repository;

import br.com.willyan.caixa.financeiro.model.Movimentacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Long> {
}
