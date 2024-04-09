package br.com.gv.pizzaorder.model.record;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UpdatePaymentRequest(@NotBlank Long id, @NotNull String payment) {
}
