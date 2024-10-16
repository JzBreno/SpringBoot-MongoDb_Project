package com.example.demo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Component;
import com.example.demo.services.ComponentsService;


//controller do component, serve para gerenciar as requisições http e retornar as requisições apropriadas
//essa classe tem retornos json ou xml
@RestController
@RequestMapping(value="/components")
public class ComponentsResource {
	//essa marcacao instancia a classe diretamente para que possamos usar as regras
	//nao se precisa istanciar diretamente e ja se pode usar os metodos
	
	@Autowired
	private ComponentsService service;
	//metodo para buscar os componentes
	//quando se faz um requisicao para /components ele exerce esse metodo
	@GetMapping
	public ResponseEntity<List<Component>> findAll(){
		//instanciando uma lista com o retorno da nossa classe que busca na base de dados
		List<Component> components = service.findAll();
		//retorna uma respota http com 200ok para nosso metodo chamado
		return ResponseEntity.ok().body(components);
	}
}
