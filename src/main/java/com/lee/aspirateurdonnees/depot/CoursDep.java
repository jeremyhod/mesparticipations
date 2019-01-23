package com.lee.aspirateurdonnees.depot;

import com.lee.aspirateurdonnees.model.Cours;

import org.springframework.data.repository.CrudRepository;

public interface CoursDep extends CrudRepository<Cours,Integer> {

}
