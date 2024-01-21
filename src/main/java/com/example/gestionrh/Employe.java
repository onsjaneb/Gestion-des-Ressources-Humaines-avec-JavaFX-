package com.example.gestionrh;

import java.util.Date;

public class Employe {
    public String id,cin,nom,prenom,etat_civil,tel1,tel2,role,niveau,ecole,nom_service;
    public Date date_naiss, date_rec, date_obt;
    public Double salaire_base;


    public Employe(String id, String cin, String nom, String prenom, String tel1, String tel2, Double salaire_base, String role,String nom_service) {
        this.id = id;
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.tel1 = tel1;
        this.tel2 = tel2;
        this.salaire_base = salaire_base;
        this.role = role;
        this.nom_service = nom_service;
    }

    public Employe() {
    }

    public Employe(String id, String cin, String nom, String prenom, String etat_civil, String tel1, String tel2, String role, String niveau, String ecole, Date date_naiss, Date date_rec, Date date_obt, Double salaire_base,String nom_service) {
        this.id = id;
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.etat_civil = etat_civil;
        this.tel1 = tel1;
        this.tel2 = tel2;
        this.role = role;
        this.niveau = niveau;
        this.ecole = ecole;
        this.date_naiss = date_naiss;
        this.date_rec = date_rec;
        this.date_obt = date_obt;
        this.salaire_base = salaire_base;
        this.nom_service = nom_service;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEtat_civil() {
        return etat_civil;
    }

    public void setEtat_civil(String etat_civil) {
        this.etat_civil = etat_civil;
    }

    public String getTel1() {
        return tel1;
    }

    public void setTel1(String tel1) {
        this.tel1 = tel1;
    }

    public String getTel2() {
        return tel2;
    }

    public void setTel2(String tel2) {
        this.tel2 = tel2;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public String getEcole() {
        return ecole;
    }

    public void setEcole(String ecole) {
        this.ecole = ecole;
    }

    public Date getDate_naiss() {
        return date_naiss;
    }

    public void setDate_naiss(Date date_naiss) {
        this.date_naiss = date_naiss;
    }

    public Date getDate_rec() {
        return date_rec;
    }

    public void setDate_rec(Date date_rec) {
        this.date_rec = date_rec;
    }

    public Date getDate_obt() {
        return date_obt;
    }

    public void setDate_obt(Date date_obt) {
        this.date_obt = date_obt;
    }

    public Double getSalaire_base() {
        return salaire_base;
    }

    public void setSalaire_base(Double salaire_base) {
        this.salaire_base = salaire_base;
    }

    public String getNom_service() {
        return nom_service;
    }

    public void setNom_service(String nom_service) {
        this.nom_service = nom_service;
    }


}
