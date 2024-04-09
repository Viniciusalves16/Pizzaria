package br.com.gv.pizzaorder.model.record;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UpdateCustomerData(
        String name,
        String cpf,
        @NotBlank
        String telephone,
        String email,
        Address address) {
}
