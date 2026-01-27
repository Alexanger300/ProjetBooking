package com.minibooking.model;

public abstract class Client extends Personne {
    public Client(String id, String nom, String email) {
        super(id, nom, email);
    }

    public abstract double getReduction();
}
