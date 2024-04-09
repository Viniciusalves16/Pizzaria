package br.com.gv.pizzaorder.controller.client;


import br.com.gv.pizzaorder.model.Customers;
import br.com.gv.pizzaorder.model.record.CustomerData;
import br.com.gv.pizzaorder.repository.CustomerRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("customers")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;


    // Cadastro de cliente
    @PostMapping
    @Transactional
    public void registerClient(@RequestBody @Valid CustomerData customerData) {
        customerRepository.save(new Customers(customerData));
    }

   //Consulta Lista de clientes
    @GetMapping()
    public Page<Customers> consultCliente(@PageableDefault(size = 10, sort = {"name"}) Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    //Consulta dados do cliente telefone
    @GetMapping("/{telephone}")
    public Customers consultClientEspecific(@PathVariable("telephone") String telephone) {
        return customerRepository.findByTelephone(telephone);
    }

    //  Excluir cadastro de clientes
    @DeleteMapping("/{telephone}")
    @Transactional
    public void deleteCustomer(@PathVariable("telephone") String telephone) {
        customerRepository.deleteByTelephone(telephone);
    }

    //Atualizacao de cadastro
    @PutMapping()
    @Transactional
    public void updateCustomerData(@RequestBody CustomerData customerData) {

        var customer = customerRepository.findByTelephone(customerData.telephone());
        customer.updateData(customerData);
    }


}
