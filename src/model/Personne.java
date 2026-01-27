package com.minibooking.model;

public abstract class Personne {
    protected String id;
    protected String nom;
    protected String email;

    public Personne(String id, String nom, String email) {
        this.id = id;
        this.nom = nom;
        this.email = email;
    }

    public String getNom() {
        return nom;
    }

    @Override
    public String toString() {
        return nom + " (" + email + ")";
    }

    public abstract void afficherDetails();
}
