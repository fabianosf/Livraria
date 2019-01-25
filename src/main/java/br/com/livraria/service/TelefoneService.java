package br.com.livraria.service;

import java.util.Collection;

import br.com.livraria.model.Telefone;

/**
 *   
 * @author Fabiano Freitas
   email: fabiano.freitas@gmail.com  	
 *
 */

public interface TelefoneService {
	
	Collection<Telefone> findAll();
	Telefone findOne(Long id);
	Telefone create(Telefone telefone);
	Telefone update(Telefone telefone);
	void delete(Long id);

}
