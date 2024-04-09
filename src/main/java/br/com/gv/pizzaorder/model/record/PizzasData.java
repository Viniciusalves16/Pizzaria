package br.com.gv.pizzaorder.model.record;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PizzasData(@NotBlank String taste, @NotBlank String ingredients,@NotNull Size_Values_Data sizeValues ) {



}
