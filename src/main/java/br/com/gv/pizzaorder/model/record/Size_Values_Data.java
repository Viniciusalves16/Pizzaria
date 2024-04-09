package br.com.gv.pizzaorder.model.record;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record Size_Values_Data(@NotBlank String size, @NotBlank String value) {
}
