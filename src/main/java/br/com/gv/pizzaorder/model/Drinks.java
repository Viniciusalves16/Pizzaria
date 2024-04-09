package br.com.gv.pizzaorder.model;

import br.com.gv.pizzaorder.model.record.DrinksData;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name = "drinks")
@Entity(name = "Drinks")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Drinks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_drink;


    private String drink_name;

    @Embedded
    private Size_Values sizeValues;

    @ManyToMany
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Requests> requests;

    public Drinks(DrinksData drinksData) {
        this.drink_name = drinksData.name();
        this.sizeValues = new Size_Values(drinksData.sizeValues());
    }
}
