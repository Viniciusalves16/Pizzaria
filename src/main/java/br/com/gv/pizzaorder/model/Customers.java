package br.com.gv.pizzaorder.model;


import br.com.gv.pizzaorder.model.record.CustomerData;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name = "customers")
@Entity(name = "Customer")
@NoArgsConstructor
@AllArgsConstructor
public class Customers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @Column(unique=true)
    private String telephone;
    private String email;

    @Embedded
    private AddressEntity address;


    public Customers(CustomerData customerData) {
        this.name = customerData.name();
        this.telephone = customerData.telephone();
        this.email = customerData.email();
        this.address = new AddressEntity(customerData.address());

    }

    public void updateData(CustomerData customerData) {
        if (customerData.name() != null) {
            this.name = customerData.name();
        }
        if (customerData.telephone() != null) {
            this.telephone = customerData.telephone();
        }
        if (customerData.email() != null) {
            this.email = customerData.email();
        }
        if (customerData.address() != null) {
          this.address.updateAdress(customerData.address());
        }
    }
}
