package br.com.gv.pizzaorder.model.record;

import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record RegisterPizza(String [] id_pizzas, String [] id_drinks) {
}
