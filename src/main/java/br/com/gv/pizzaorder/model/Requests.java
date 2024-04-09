package br.com.gv.pizzaorder.model;


import br.com.gv.pizzaorder.enumeration.Payment;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name = "requests")
@Entity(name = "Request")
@Data
@Builder // intermediario
@NoArgsConstructor
@AllArgsConstructor
public class Requests {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long order_id;

    @ManyToMany
    private List<Pizzas> pizzas;

    @ManyToMany
    private List<Drinks> drinks;

    @Enumerated(EnumType.STRING)
    private Payment payment;



}
