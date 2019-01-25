package br.com.livraria.service;

import java.util.Collection;

import br.com.livraria.model.Endereco;

/**
 *   
 * @author Fabiano Freitas
   email: fabiano.freitas@gmail.com  	
 *
 */

public interface EnderecoService {

	Collection<Endereco> findAll();
	Endereco findOne(Long id);
	Endereco create(Endereco endereco);
	Endereco update(Endereco endereco);
	void delete(Long id);
	
}
