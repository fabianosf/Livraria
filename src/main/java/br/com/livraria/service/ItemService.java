package br.com.livraria.service;

import java.util.Collection;

import br.com.livraria.model.Item;


/**
 * 
 * @author Fabiano Freitas
   email: fabiano.freitas@gmail.com  	
 *
 */
public interface ItemService {
	
	Collection<Item> findAll();
	Item findOne(Long id);
	Item create(Item item);
	Item update(Item item);
	void delete(Long id);

}
