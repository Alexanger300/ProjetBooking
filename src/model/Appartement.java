package com.minibooking.model;

public class Appartement extends Hebergement {
    private int etage;
    private boolean cuisineEquipee;

    public Appartement(String id, String nom, String localisation, double prixParNuit, double noteMoyenne, int etage, boolean cuisineEquipee) {
        super(id, nom, localisation, prixParNuit, noteMoyenne);
        this.etage = etage;
        this.cuisineEquipee = cuisineEquipee;
    }

    @Override
    public void afficherDetails() {
        System.out.println("[Appartement] " + super.toString() + " | Étage: " + etage + " | Cuisine: " + (cuisineEquipee ? "Oui" : "Non"));
    }
}
