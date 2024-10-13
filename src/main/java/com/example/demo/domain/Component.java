package com.example.demo.domain;

import java.io.Serializable;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection = "component")
public class Component implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	private String id;
	private String name ;
	private String details;
	
	public Component(){}
	
	public Component(String id, String name, String details) {
		super();
		this.id = id;
		this.name = name;
		this.details = details;
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Component other = (Component) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
}
