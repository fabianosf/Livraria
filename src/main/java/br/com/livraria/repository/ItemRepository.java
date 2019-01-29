package br.com.livraria.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.livraria.model.Item;

/**
 *   
 * @author Fabiano Freitas
   email: fabiano.freitas@gmail.com  	
 *
 */
public interface ItemRepository extends CrudRepository<Item, Long> {
	

}
