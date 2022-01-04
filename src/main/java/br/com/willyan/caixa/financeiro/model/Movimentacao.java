package br.com.willyan.caixa.financeiro.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

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
public class Movimentacao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate data;

    @NotBlank(message = "O campo não deve ser vazio")
    private String tipo;

    private String descricao;

    @NotNull
    @Min(0)
    private Double valor;

    @Deprecated
    protected Movimentacao(){}

    public Movimentacao(LocalDate data, String tipo, String descricao, Double valor){
        this.data = data;
        this.tipo = tipo;
        this.descricao=descricao;
        this.valor=valor;
    }


    @Override
    public String toString() {
        return "Movimentacao{" +
                "tipo='" + tipo + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movimentacao that = (Movimentacao) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
