package br.com.livraria.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.livraria.model.Endereco;

/**
 *   
 * @author Fabiano Freitas
   email: fabiano.freitas@gmail.com  	
 *
 */

public interface EnderecoRepository extends CrudRepository<Endereco, Long> {

}
