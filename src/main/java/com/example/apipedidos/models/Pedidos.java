package com.example.apipedidos.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity @Table(name = "pedidos") @Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Pedidos {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 40)
    private String identificador;

    @NotBlank(message = "O nome do produto é obrigatório")
    @Column(nullable = false, length = 150)
    private String nomeProduto;

    @NotNull(message = "A quantidade é obrigatória")
    @Min(value = 0, message = "A quantidade deve ser maior que zero")
    @Column(nullable = false)
    private Integer quantidade;

    @NotNull(message = "O valor do produto é obrigatório")
    @DecimalMin(value = "0.01", message = "O valor deve ser maior que zero")
    @Digits(integer = 10, fraction = 2)
    @Column(nullable = false)
    private Double valorProduto;
}
