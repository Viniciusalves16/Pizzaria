package br.com.gv.pizzaorder.model;

import br.com.gv.pizzaorder.model.record.Size_Values_Data;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Size_Values {


    private String size;
    private String value;

    public Size_Values(Size_Values_Data sizeValues) {
        this.size = sizeValues.size();
        this.value = sizeValues.value();
    }

    public Size_Values(Size_Values sizeValues) {
        this.size = sizeValues.getSize();
        this.value = sizeValues.getValue();
    }


    public void updateAdress(Size_Values_Data sizeValuesData) {
        if (sizeValuesData.size() != null) {
            this.size = sizeValuesData.size();
            this.value = sizeValuesData.value();
        }
    }
}
