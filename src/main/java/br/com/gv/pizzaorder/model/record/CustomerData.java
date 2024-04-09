package br.com.gv.pizzaorder.model.record;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import br.com.gv.pizzaorder.model.record.Address;

public record CustomerData(

        @NotBlank
        String name,
        @NotBlank
        String cpf,
        @NotBlank
        String telephone,
        @Email
        String email,

        @NotNull @Valid
        Address address) {
}
