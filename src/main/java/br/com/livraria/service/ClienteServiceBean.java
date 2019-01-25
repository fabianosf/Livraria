package br.com.livraria.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.livraria.model.Cliente;
import br.com.livraria.repository.ClienteRepository;

/**
 *   
 * @author Fabiano Freitas
   email: fabiano.freitas@gmail.com  	
 *
 */

@Service
public class ClienteServiceBean implements ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Override
	public Collection<Cliente> findAll() {
		Collection<Cliente> clientes = (Collection<Cliente>) clienteRepository.findAll();
		return clientes;
	}

	@Override
	public Cliente findOne(Long id) {
		 Cliente cliente = clienteRepository.findOne(id);
		return cliente;
	}

	@Override
	public Cliente create(Cliente cliente) {
		 if(cliente.getId() != null) {
			 return null;
		 }
		 Cliente saveCliente = clienteRepository.save(cliente);
		return saveCliente;
	}

	@Override
	public Cliente update(Cliente cliente) {
		  Cliente clientePersiste = findOne(cliente.getId());
		  if(clientePersiste == null) {
			  return null;
		  }
		  Cliente updateCliente = clienteRepository.save(cliente);
		  return updateCliente;
	}

	@Override
	public void delete(Long id) {
		clienteRepository.delete(id);
		
	}

}












