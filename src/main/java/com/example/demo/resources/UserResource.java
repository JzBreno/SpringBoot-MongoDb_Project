package com.example.demo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.User;
import com.example.demo.services.UserService;


//controller do component, serve para gerenciar as requisições http e retornar as requisições apropriadas
//essa classe tem retornos json ou xml
@RestController
@RequestMapping(value="/users")
public class UserResource {
	//essa marcacao instancia a classe diretamente para que possamos usar as regras
	//nao se precisa istanciar diretamente e ja se pode usar os metodos
		
	@Autowired
	private UserService service;
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		List<User> users = service.findAll();
		return ResponseEntity.ok().body(users);
		
	}
	
}
