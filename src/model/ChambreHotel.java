package com.minibooking.model;

public class ChambreHotel extends Hebergement {
    private int numeroChambre;
    private boolean petitDejeunerInclus;

    public ChambreHotel(String id, String nom, String localisation, double prixParNuit, double noteMoyenne, int numeroChambre, boolean petitDejeunerInclus) {
        super(id, nom, localisation, prixParNuit, noteMoyenne);
        this.numeroChambre = numeroChambre;
        this.petitDejeunerInclus = petitDejeunerInclus;
    }

    @Override
    public void afficherDetails() {
        System.out.println("[Hôtel] " + super.toString() + " | Chambre n°" + numeroChambre + " | Dej inclus: " + (petitDejeunerInclus ? "Oui" : "Non"));
    }
}
