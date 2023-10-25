package com.exemple.springBoot.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProdutoRecordDTO(@NotBlank String nome, @NotNull BigDecimal valor) {
}
