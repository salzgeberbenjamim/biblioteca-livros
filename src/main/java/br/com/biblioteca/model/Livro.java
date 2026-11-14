package br.com.biblioteca.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;

@Entity
@Table(name = "livros")
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Informe o título.")
    @Size(max = 120, message = "O título deve ter no máximo 120 caracteres.")
    @Column(nullable = false, length = 120)
    private String titulo;

    @NotBlank(message = "Informe o autor.")
    @Size(max = 100, message = "O autor deve ter no máximo 100 caracteres.")
    @Column(nullable = false, length = 100)
    private String autor;

    @NotNull(message = "Informe o ano.")
    @Min(value = 1000, message = "Informe um ano válido.")
    @Max(value = 2100, message = "Informe um ano válido.")
    @Column(nullable = false)
    private Integer ano;

    @NotNull(message = "Informe o preço.")
    @DecimalMin(value = "0.00", inclusive = true, message = "O preço não pode ser negativo.")
    @Digits(integer = 8, fraction = 2, message = "Use até 2 casas decimais.")
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal preco;

    @NotNull(message = "Informe o estoque.")
    @Min(value = 0, message = "O estoque não pode ser negativo.")
    @Column(nullable = false)
    private Integer estoque;

    public Livro() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }
    public Integer getAno() { return ano; }
    public void setAno(Integer ano) { this.ano = ano; }
    public BigDecimal getPreco() { return preco; }
    public void setPreco(BigDecimal preco) { this.preco = preco; }
    public Integer getEstoque() { return estoque; }
    public void setEstoque(Integer estoque) { this.estoque = estoque; }
}
