package br.com.willyan.caixa.financeiro.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Objects;


@Entity
@Getter
@Setter
public class Caixa {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;



    @NotBlank(message = "Descrição não pode ser vazia")
    private String descricao;

    @NotNull(message = "Deve inserir um valor")
    @Min(0)
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
