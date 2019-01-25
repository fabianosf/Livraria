package br.com.livraria.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.livraria.model.Login;

/**
 *   
 * @author Fabiano Freitas
   email: fabiano.freitas@gmail.com  	
 *
 */

public interface LoginRepository extends CrudRepository<Login, Long>{
	

}
