package br.com.livraria.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.livraria.model.Telefone;
import br.com.livraria.repository.TelefoneRepository;

@Service
public class TelefoneServiceBean implements TelefoneService {
	
	@Autowired
	private TelefoneRepository telefoneRepository;

	@Override
	public Collection<Telefone> findAll() {
		Collection<Telefone>telefones = (Collection<Telefone>) telefoneRepository.findAll();
		 return telefones;
		 
	}

	@Override
	public Telefone findOne(Long id) {
		Telefone telefone = telefoneRepository.findOne(id);
		return telefone;
	}

	@Override
	public Telefone create(Telefone telefone) {
		 if(telefone.getId()!=null) {
			 return null;
		 }
		 Telefone savedTelefone = telefoneRepository.save(telefone);
		 return savedTelefone;
	}

	@Override
	public Telefone update(Telefone telefone) {
		Telefone telefonePersisted = findOne(telefone.getId());
		 if(telefonePersisted == null) {
			 return null;
		 }
		 Telefone updatedTelefone = telefoneRepository.save(telefone);
		 return updatedTelefone;
	}

	@Override
	public void delete(Long id) {
		telefoneRepository.delete(id);
		
	}
	
	
	

}
