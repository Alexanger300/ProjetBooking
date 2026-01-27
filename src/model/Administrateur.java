package com.minibooking.model;

public class Administrateur extends Personne {
    private String niveauAcces;

    public Administrateur(String id, String nom, String email, String niveauAcces) {
        super(id, nom, email);
        this.niveauAcces = niveauAcces;
    }

    @Override
    public void afficherDetails() {
        System.out.println("[Admin] " + super.toString() + " - Niveau: " + niveauAcces);
    }
    
    public boolean peutSupprimer() {
        return "SUPER_ADMIN".equals(niveauAcces);
    }
}
