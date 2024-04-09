package br.com.gv.pizzaorder.repository;

import br.com.gv.pizzaorder.model.Customers;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CustomerRepository extends JpaRepository<Customers,Long> {


    Customers findByTelephone(String telephone);


    void deleteByTelephone(String telephone);
}
