package br.com.gv.pizzaorder.controller.adm;

import br.com.gv.pizzaorder.model.Drinks;
import br.com.gv.pizzaorder.model.record.DrinksData;
import br.com.gv.pizzaorder.repository.DrinksRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("drinks")
public class DrinksController {

    @Autowired
    private DrinksRepository drinksRepository;

    @PostMapping
    @Transactional // registro de bebida
    public void registerDrinks(@RequestBody @Valid DrinksData drinksData) {
        drinksRepository.save(new Drinks(drinksData));
    }

    @GetMapping // Lista de bebidas
    public List<Drinks> consultDrinks() {
       return  drinksRepository.findAll();
    }

    @DeleteMapping("/{id}")
    @Transactional // Exclusao de bebida
    public void deleteDrink(@PathVariable("id") String id) {
        drinksRepository.deleteById(Long.valueOf(id));
    }




}
