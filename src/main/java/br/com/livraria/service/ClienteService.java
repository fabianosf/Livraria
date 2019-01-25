package br.com.livraria.service;

import java.util.Collection;

import br.com.livraria.model.Cliente;

/**
 *   
 * @author Fabiano Freitas
   email: fabiano.freitas@gmail.com  	
 *
 */

public interface ClienteService {
	
	Collection<Cliente> findAll();
	Cliente findOne(Long id);
	Cliente create(Cliente cliente);
	Cliente update(Cliente cliente);
	void delete(Long id);

}
