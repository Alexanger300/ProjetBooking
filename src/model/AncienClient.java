package com.minibooking.model;

public class AncienClient extends Client {
    private int pointFidelite;

    public AncienClient(String id, String nom, String email, int pointFidelite) {
        super(id, nom, email);
        this.pointFidelite = pointFidelite;
    }

    @Override
    public double getReduction() {
        return pointFidelite > 100 ? 0.10 : 0.05;
    }

    @Override
    public void afficherDetails() {
        System.out.println("[Ancien Client] " + super.toString() + " - Points: " + pointFidelite + " - Réduction: " + (getReduction() * 100) + "%");
    }
}
