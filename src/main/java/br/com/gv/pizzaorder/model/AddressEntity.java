package br.com.gv.pizzaorder.model;

import br.com.gv.pizzaorder.model.record.Address;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressEntity {

    private String code;
    private String street;
    private String district;
    private String city;
    private String number;
    private String complement;


    public AddressEntity(Address address) {
        this.code = address.code();
        this.street = address.street();
        this.district = address.street();
        this.city = address.city();
        this.number = address.number();
        this.complement = address.complement();
    }


    public void updateAdress(Address address) {
        if (address.code() != null) {
            this.code = address.code();
        }
        if (address.street() != null) {
            this.street = address.street();
        }
        if (address.district() != null) {
            this.district = address.district();
        }
        if (address.city() != null) {
            this.city = address.city();
        }
        if (address.number() != null) {
            this.number = address.number();
        }
        if (address.complement() != null) {
            this.complement = address.complement();
        }

    }
}
