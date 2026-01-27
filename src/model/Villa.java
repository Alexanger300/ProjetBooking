package com.minibooking.model;

public class Villa extends Hebergement {
    private boolean piscinePrivee;
    private double surfaceJardin;

    public Villa(String id, String nom, String localisation, double prixParNuit, double noteMoyenne, boolean piscinePrivee, double surfaceJardin) {
        super(id, nom, localisation, prixParNuit, noteMoyenne);
        this.piscinePrivee = piscinePrivee;
        this.surfaceJardin = surfaceJardin;
    }

    @Override
    public void afficherDetails() {
        System.out.println("[Villa] " + super.toString() + " | Piscine: " + (piscinePrivee ? "Oui" : "Non") + " | Jardin: " + surfaceJardin + "m²");
    }
}
