package com.minibooking.model;

public class NouveauClient extends Client {
    public NouveauClient(String id, String nom, String email) {
        super(id, nom, email);
    }

    @Override
    public double getReduction() {
        return 0.0;
    }

    @Override
    public void afficherDetails() {
        System.out.println("[Nouveau Client] " + super.toString() + " - Réduction: 0%");
    }
}
