package br.com.livraria.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.livraria.model.Endereco;
import br.com.livraria.repository.EnderecoRepository;

/**
 *   
 * @author Fabiano Freitas
   email: fabiano.freitas@gmail.com  	
 *
 */

@Service
public class EnderecoServiceBean implements EnderecoService {
	
	@Autowired
	private EnderecoRepository enderecoRepository;

	@Override
	public Collection<Endereco> findAll() {
		Collection<Endereco> enderecos = (Collection<Endereco>) enderecoRepository.findAll();
		return enderecos;
		 
	}

	@Override
	public Endereco findOne(Long id) {
		Endereco endereco = enderecoRepository.findOne(id);
		return endereco;
	}

	@Override
	public Endereco create(Endereco endereco) {
		 if(endereco.getId() != null) {
			 return null;
		 }
		 Endereco saveEndereco = enderecoRepository.save(endereco);
		return saveEndereco;
	
	}

	@Override
	public Endereco update(Endereco endereco) {
		Endereco enderecoPersiste = findOne(endereco.getId());
		  if(enderecoPersiste == null) {
			  return null;
		  }
		  Endereco updateEndereco = enderecoRepository.save(endereco);
		  return updateEndereco;
		 
	}

	@Override
	public void delete(Long id) {
		enderecoRepository.delete(id);
		
	}

}












