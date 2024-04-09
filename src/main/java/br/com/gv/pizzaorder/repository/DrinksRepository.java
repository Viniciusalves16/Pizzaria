package br.com.gv.pizzaorder.repository;

import br.com.gv.pizzaorder.model.Drinks;
import br.com.gv.pizzaorder.model.Pizzas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DrinksRepository extends JpaRepository<Drinks,Long> {
}
