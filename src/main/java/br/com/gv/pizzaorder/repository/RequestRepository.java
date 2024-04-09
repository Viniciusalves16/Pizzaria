package br.com.gv.pizzaorder.repository;

import br.com.gv.pizzaorder.model.Requests;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestRepository extends JpaRepository<Requests,Long> {
}
