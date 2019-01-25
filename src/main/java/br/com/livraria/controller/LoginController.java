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

import br.com.livraria.model.Login;
import br.com.livraria.service.LoginService;

/**
 *   
 * @author Fabiano Freitas
   email: fabiano.freitas@gmail.com  	
 *
 */

@Controller
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@RequestMapping(value = "/logins", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Login>> getLogins() {
		Collection<Login> logins = loginService.findAll();
		return new ResponseEntity<Collection<Login>>(logins, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/logins/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Login> getLogin(@PathVariable("id") Long id) {
		Login login = loginService.findOne(id);
		if (login == null) {
			return new ResponseEntity<Login>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Login>(login, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/logins", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Login> createLogin(@RequestBody Login login) {
		Login savedLogin = loginService.create(login);
		return new ResponseEntity<Login>(savedLogin, HttpStatus.CREATED);
	}
	
	
	@RequestMapping(value = "/logins/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Login> updateLogin(@PathVariable("id") Long id, @RequestBody Login login) {
		Login updatedLogin = null;
		if (login != null && id == login.getId()) {
			updatedLogin = loginService.update(login);
		}
		if (updatedLogin == null) {
			return new ResponseEntity<Login>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Login>(updatedLogin, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/logins/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Login> deleteLogin(@PathVariable("id") Long id) {
		loginService.delete(id);
		return new ResponseEntity<Login>(HttpStatus.NO_CONTENT);
	}
	
	
	
	

}
