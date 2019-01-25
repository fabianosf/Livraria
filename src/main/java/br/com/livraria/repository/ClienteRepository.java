package br.com.livraria.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.livraria.model.Cliente;

/**
 *   
 * @author Fabiano Freitas
   email: fabiano.freitas@gmail.com  	
 *
 */

public interface ClienteRepository extends CrudRepository<Cliente, Long> {
	List<Cliente> findByNome(String nome);

}
