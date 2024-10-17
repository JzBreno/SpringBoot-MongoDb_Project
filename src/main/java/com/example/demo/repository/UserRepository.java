package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.domain.User;
//essa interface se comunica com a base de dados mongo
//essaninterface extend de outra interface que herda funcoes pre definidas em MongoRepository
@Repository
public interface UserRepository extends MongoRepository<User, String> {

	
	//herda
}
