package br.com.willyan.caixa.financeiro.repository;

import br.com.willyan.caixa.financeiro.model.Caixa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CaixaRepository extends JpaRepository<Caixa, Long> {
}
