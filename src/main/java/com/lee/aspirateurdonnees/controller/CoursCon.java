package com.lee.aspirateurdonnees.controller;

import com.lee.aspirateurdonnees.service.CoursSerInt;
import com.lee.aspirateurdonnees.model.Cours;
import com.lee.aspirateurdonnees.asp.CoursDataAspirateur;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class CoursCon {

    @Autowired
    CoursSerInt coursSerInt;

    @RequestMapping(value = "/cours", produces = "text/csv")
    public void findCours(HttpServletResponse res) throws IOException {

        List<Cours> coursList = (List<Cours>) coursSerInt.findAll();

        CoursDataAspirateur.h2ToCvs(res.getWriter(), coursList);

    }

}

