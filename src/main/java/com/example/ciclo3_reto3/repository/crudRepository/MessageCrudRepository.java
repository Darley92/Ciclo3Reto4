package com.example.ciclo3_reto3.repository.crudRepository;


import com.example.ciclo3_reto3.entities.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageCrudRepository extends CrudRepository<Message,Integer> {
}
