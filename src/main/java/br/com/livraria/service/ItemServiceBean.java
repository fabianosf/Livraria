package br.com.livraria.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.livraria.model.Item;
import br.com.livraria.repository.ItemRepository;

@Service
public class ItemServiceBean implements ItemService {	
	
	@Autowired
	private ItemRepository itemRepository;

	@Override
	public Collection<Item> findAll() {
		 Collection<Item>itens = (Collection<Item>) itemRepository.findAll();
		 return itens;
	}

	@Override
	public Item findOne(Long id) {
		 return itemRepository.findOne(id);
	}

	@Override
	public Item create(Item item) {
		 return itemRepository.save(item);
		 
	}

	@Override
	public Item update(Item item) {
		 Item persistedItem = itemRepository.findOne(item.getId());
		 if(persistedItem == null) {
			 return null;
		 }
		 return itemRepository.save(item);
	}

	@Override
	public void delete(Long id) {
		itemRepository.delete(id);
		
	}
	
	
	

}
