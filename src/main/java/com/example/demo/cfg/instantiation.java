package com.example.demo.cfg;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.example.demo.domain.Component;
import com.example.demo.domain.User;
import com.example.demo.repository.ComponentsRepository;
import com.example.demo.repository.UserRepository;

@Configuration
public class instantiation implements CommandLineRunner{
	
	@Autowired
	UserRepository userRepository;
	@Autowired
	ComponentsRepository componentRepository;
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		userRepository.deleteAll();
		componentRepository.deleteAll();
		
		User maria = new User(null, "maria brown", "maria@gmail.com");
		User joe = new User(null, "joe brown", "joe@gmail.com");
		Component motherBoard = new Component(null, "mother board Asus","placa mae de alta qaulidade ddr4");
		
		try {
	        userRepository.saveAll(Arrays.asList(maria, joe));
	        componentRepository.saveAll(Arrays.asList(motherBoard));
	        System.out.println("Usuários criados com sucesso!");
	        System.out.println("Componentes criados com sucesso!");

	    } catch (Exception e) {
	        System.err.println("Erro ao criar usuários: " + e.getMessage());
	    }
	}

}
