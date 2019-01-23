package com.lee.aspirateurdonnees.model;

import java.time.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;

@Entity
public class Cours{

    @Id
    @GeneratedValue
    private int id;

    // typeEvenement : (cours, conférence, débat, etc.)
    private String typeEvenement;

    // nomEvenement
    private String nomEvenement;

    // typeParticipation : (apprenant·e, animation, organisation)
    private String typeParticipation;

    // date : dd/mm/yy hh:mm:ss
    private LocalDateTime dateDebut;
    private LocalDateTime dateFin;

    // duree
    private Long duree;

    // confrontation à un agenda (ici je n’y étais pas, ici j’y étais etc.)
    private boolean presence;


    public Cours() {

    }

    public Cours(String typeEvenement, String nomEvenement, String typeParticipation, LocalDateTime dateDebut, LocalDateTime dateFin, Long duree, boolean presence) {
        this.typeEvenement = typeEvenement;
        this.nomEvenement = nomEvenement;
        this.typeParticipation = typeParticipation;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.duree = duree;
        this.presence = presence;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypeEvenement() {
        return typeEvenement;
    }

    public void setTypeEvenement(String typeEvenement) {
        this.typeEvenement = typeEvenement;
    }

    public String getNomEvenement() {
        return nomEvenement;
    }

    public void setNomEvenement(String nomEvenement) {
        this.nomEvenement = nomEvenement;
    }

    public String getTypeParticipation() {
        return typeParticipation;
    }

    public void setTypeParticipation(String typeParticipation) {
        this.typeParticipation = typeParticipation;
    }

    public LocalDateTime getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDateTime dateDebut) {
        this.dateDebut = dateDebut;
    }

    public LocalDateTime getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDateTime dateFin) {
        this.dateFin = dateFin;
    }

    public Long getDuree() {
        return duree;
    }

    public void setDuree(Long duree) {
        this.duree = duree;
    }

    public boolean isPresence() {
        return presence;
    }

    public void setPresence(boolean presence) {
        this.presence = presence;
    }

    @Override
    public String toString() {
        return "Cours{" +
                "id=" + id +
                ", typeEvenement='" + typeEvenement + '\'' +
                ", nomEvenement='" + nomEvenement + '\'' +
                ", typeParticipation='" + typeParticipation + '\'' +
                ", dateDebut=" + dateDebut +
                ", dateFin=" + dateFin +
                ", duree=" + duree +
                ", presence=" + presence +
                '}';
    }

}