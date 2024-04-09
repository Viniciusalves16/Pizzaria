package br.com.gv.pizzaorder.model;

import br.com.gv.pizzaorder.model.record.PizzasData;
import br.com.gv.pizzaorder.model.record.Size_Values_Data;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Optional;

@Table(name = "pizzas")
@Entity(name = "Pizza")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pizzas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique=true)
    private Long id_Pizza;
    @Column(unique=true)
    private String taste;
    @Column(unique=true)
    private String ingredients;

    @Embedded
    private Size_Values sizeValues;

    @ManyToMany
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Requests> requests;


    public Pizzas(PizzasData p) {
        this.taste = p.taste();
        this.ingredients = p.ingredients();
        this.sizeValues = new Size_Values(p.sizeValues()) ;

    }



    public void updatePizza(PizzasData p) {
        if (p.taste() != null) {
            this.taste = p.taste();
        }
        if (p.ingredients() != null) {
            this.ingredients = p.ingredients();
        }
        if (p.sizeValues() != null) {
            this.sizeValues.updateAdress(p.sizeValues());
        }
    }
}
