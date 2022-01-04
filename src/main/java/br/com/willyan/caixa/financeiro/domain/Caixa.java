package br.com.willyan.caixa.financeiro.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
@Getter
@Setter
public class Caixa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    private String descricao;
    private Double saldoInicial;

    protected Caixa(){}

    public Caixa(String descricao, Double saldoInicial){
        this.descricao=descricao;
        this.saldoInicial=saldoInicial;
    }

    @Override
    public String toString() {
        return "Caixa{" +
                "descricao='" + descricao + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Caixa caixa = (Caixa) o;
        return id.equals(caixa.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
