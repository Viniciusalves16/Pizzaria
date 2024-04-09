package br.com.gv.pizzaorder.controller.client.request;

import br.com.gv.pizzaorder.enumeration.Payment;
import br.com.gv.pizzaorder.model.Drinks;
import br.com.gv.pizzaorder.model.Pizzas;
import br.com.gv.pizzaorder.model.Requests;
import br.com.gv.pizzaorder.model.record.RegisterPizza;
import br.com.gv.pizzaorder.model.record.UpdatePaymentRequest;
import br.com.gv.pizzaorder.repository.DrinksRepository;
import br.com.gv.pizzaorder.repository.PizzasRepository;
import br.com.gv.pizzaorder.repository.RequestPizzaRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("request")
public class RequestController {

    @Autowired
    RequestPizzaRepository requestPizzaRepository;

    @Autowired
    PizzasRepository pizzasRepository;

    @Autowired
    DrinksRepository drinksRepository;

    @PostMapping()
    @Transactional
    public void registerRequestCliente(@RequestBody RegisterPizza registerPizza) {

        List<Pizzas> pizzas = new ArrayList<>();
        List<Drinks> drinks = new ArrayList<>();


        Arrays.stream(registerPizza.id_pizzas()).toList().forEach((id_pizzas) -> {
            Optional<Pizzas> byId = pizzasRepository.findById(Long.valueOf(id_pizzas));
            pizzas.add(byId.get());
        });

        Arrays.stream(registerPizza.id_drinks()).toList().forEach((id_drinks) -> {
            Optional<Drinks> byIdDrinks = drinksRepository.findById(Long.valueOf(id_drinks));
            drinks.add(byIdDrinks.get());
        });

        //todo: construtor que nao exige parametro obrigatorio
        //todo: @Builder na classe entity
        requestPizzaRepository.save(Requests.builder().pizzas(pizzas).drinks(drinks).build());
    }

    @PutMapping
    @Transactional
    public void updatePaymentClient(@RequestBody @Valid UpdatePaymentRequest p) {
        Requests requests = requestPizzaRepository.getReferenceById(p.id());
        requests.setPayment(Payment.valueOf(p.payment()));
        requestPizzaRepository.save(requests);

    }


}
