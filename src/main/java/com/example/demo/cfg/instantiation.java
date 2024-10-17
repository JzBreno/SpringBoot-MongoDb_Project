package com.example.demo.cfg;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.example.demo.domain.Component;
import com.example.demo.domain.User;
import com.example.demo.repository.ComponentsRepository;
import com.example.demo.repository.UserRepository;
//essa classe é responsavel por instanciar nossas entidades
@Configuration
public class instantiation implements CommandLineRunner{
	//essa anotação @Autoeired instancia de forma automatica nossos Repository(classe que implementa interface com metodos de conexão com o mongodb)
	@Autowired
	UserRepository userRepository;
	@Autowired
	ComponentsRepository componentRepository;
	//metodo para inicializar as inserções das nossas entidades
	@Override
	public void run(String... args) throws Exception {
		
		// TODO Auto-generated method stub
		//deletando o que tiver salvo no banco 
		userRepository.deleteAll();
		componentRepository.deleteAll();
		//instanciando entidades
		User maria = new User(null, "maria brown", "maria@gmail.com");
		User joe = new User(null, "joe brown", "joe@gmail.com");
		Component motherBoard = new Component(null, "mother board Asus","placa mae de alta qaulidade ddr4");
		
		//tratando possiveis erros
		try {
			//salvando todos as nossas entidades passando como referencia ao nossos xRepository
	        userRepository.saveAll(Arrays.asList(maria, joe));
	        componentRepository.saveAll(Arrays.asList(motherBoard));
	        System.out.println("Usuários criados com sucesso!");
	        System.out.println("Componentes criados com sucesso!");

	    } catch (Exception e) {
	    	//printando a possivel mensagem de erro
	        System.err.println("Erro ao criar usuários: " + e.getMessage());
	    }
	}

}
