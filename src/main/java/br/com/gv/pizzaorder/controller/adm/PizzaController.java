package br.com.gv.pizzaorder.controller.adm;

import br.com.gv.pizzaorder.model.Pizzas;
import br.com.gv.pizzaorder.model.record.PizzasData;
import br.com.gv.pizzaorder.repository.PizzasRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pizza")
public class PizzaController {

    @Autowired
    PizzasRepository pizzasRepository;

    @PostMapping
    @Transactional // Adm registra novo sabor de pizza
    public void registerPizza(@RequestBody @Valid PizzasData p) {
        pizzasRepository.save(new Pizzas(p));
    }


    @GetMapping() // Lista de pizzas
    public Page<Pizzas> consultGeralListPizzas(@PageableDefault(size = 10, sort = {"taste"}) Pageable pageable) {
        return pizzasRepository.findAll(pageable);
    }


    @DeleteMapping("/{id_pizza}") // Exclusao de sabor
    @Transactional
    public void deleteTaste(@PathVariable("id_pizza") Long id_pizza) {
        pizzasRepository.deleteById(id_pizza);
    }

    @PutMapping() // Editar valores e sabor de pizzas
    @Transactional
    public void UpdateTaste(@RequestBody PizzasData p) {
        var pizzas = pizzasRepository.findByTaste(p.taste());
        pizzas.updatePizza(p);

    }


}
