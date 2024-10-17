package com.example.demo.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.User;
import com.example.demo.dto.UserDTO;
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
	public ResponseEntity<List<UserDTO>> findAll(){
		List<User> users = service.findAll();
		//transformando um alista do tipo User em UserDTO
		                        //aqui transforma em uma lista que se pode usar o metodo lambda
		                                          //insercao do metodo lambda
		                                                               //aqui reconverte ao tipo lista
		List<UserDTO> listDto = users.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
		
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
 	public ResponseEntity<UserDTO> findById(@PathVariable String id) {
		User obj = service.findById(id);
		return ResponseEntity.ok().body(new UserDTO(obj));
	}
	
}
