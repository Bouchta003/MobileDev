package com.example.mobileproject.Classes;

public class User {
    //https://jsonplaceholder.org/users
    private int id;
    private static int idcount = 0;
    private String nom;
    private String prenom;
    private String service;
    private int score;
    private String password;
    private String username;
    private int rank;


    public User(String nom, String prenom, String service, String password, String username) {
        this.nom = nom;
        this.prenom = prenom;
        this.service = service;
        this.password = password;
        this.username = username;
        idcount++;
        this.id=idcount;
        this.score=0;
        this.rank = -1;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public void CalculScore(){

    }
}
