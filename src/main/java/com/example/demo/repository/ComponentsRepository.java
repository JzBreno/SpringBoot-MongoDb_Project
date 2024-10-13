package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.domain.Component;
//essa interface se comunica com a base de dados mongo
//essaninterface extend de outra interface que herda funcoes pre definidas em MongoRepository
public interface ComponentsRepository extends MongoRepository<Component, String> {

}
