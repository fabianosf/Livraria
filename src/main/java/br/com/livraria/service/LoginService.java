package br.com.livraria.service;

import java.util.Collection;

import br.com.livraria.model.Login;

/**
 *   
 * @author Fabiano Freitas
   email: fabiano.freitas@gmail.com  	
 *
 */

public interface LoginService {
	
	Collection<Login> findAll();
	Login findOne(Long id);
	Login create(Login login);
	Login update(Login login);
	void delete(Long id);

}
