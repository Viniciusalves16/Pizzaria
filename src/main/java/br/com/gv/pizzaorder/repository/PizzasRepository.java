package br.com.gv.pizzaorder.repository;

import br.com.gv.pizzaorder.model.Pizzas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface PizzasRepository extends JpaRepository<Pizzas,Long> {
    void deleteByTaste(String taste);

    Pizzas findByTaste(String taste);
}
