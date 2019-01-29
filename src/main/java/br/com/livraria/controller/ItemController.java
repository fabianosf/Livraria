package br.com.livraria.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.livraria.model.Item;
import br.com.livraria.service.ItemService;

/**
 * 
 * @author Fabiano Freitas email: fabiano.freitas@gmail.com
 *
 */

@Controller
public class ItemController {

	@Autowired
	private ItemService itemService;

	@RequestMapping(value = "/itens", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Item>> getItens() {
		Collection<Item> itens = itemService.findAll();
		return new ResponseEntity<Collection<Item>>(itens, HttpStatus.OK);
	}

	@RequestMapping(value = "/itens/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Item> getItem(@PathVariable("id") Long id) {
		Item item = itemService.findOne(id);
		if (item == null) {
			return new ResponseEntity<Item>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Item>(item, HttpStatus.OK);
	}

	@RequestMapping(value = "/itens", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Item> createItem(@RequestBody Item item) {
		Item savedItem = itemService.create(item);
		return new ResponseEntity<Item>(savedItem, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/itens/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Item> updateItem(@PathVariable("id") Long id, @RequestBody Item item) {
		Item updatedItem = null;
		if (item != null && id == item.getId()) {
			updatedItem = itemService.update(item);
		}
		if (updatedItem == null) {
			return new ResponseEntity<Item>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Item>(updatedItem, HttpStatus.OK);
	}

	@RequestMapping(value = "/itens/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Item> deleteItem(@PathVariable("id") Long id) {
		itemService.delete(id);
		return new ResponseEntity<Item>(HttpStatus.NO_CONTENT);
	}

}
