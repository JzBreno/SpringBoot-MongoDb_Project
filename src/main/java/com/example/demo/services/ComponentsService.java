package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Component;
import com.example.demo.repository.ComponentsRepository;

//essa classe trata em promeira mao com a classe que gerencia os repositorios
@Service
public class ComponentsService {
	@Autowired
	private ComponentsRepository repo;
	
	public List<Component> findAll(){
		return repo.findAll();
	}
}
