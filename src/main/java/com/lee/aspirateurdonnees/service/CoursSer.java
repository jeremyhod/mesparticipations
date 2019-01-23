package com.lee.aspirateurdonnees.service;

import com.lee.aspirateurdonnees.depot.CoursDep;
import com.lee.aspirateurdonnees.model.Cours;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class CoursSer implements CoursSerInt {

    @Autowired
    private CoursDep coursDep;

    @Override
    public List<Cours> findAll() {

        List<Cours> coursList = (List<Cours>) coursDep.findAll();

        return coursList;
    }


}