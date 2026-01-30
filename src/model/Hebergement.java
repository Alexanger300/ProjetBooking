package com.minibooking.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Hebergement implements Reservable, Comparable<Hebergement> {
    protected String id, nom, localisation;;
    protected double prixParNuit, noteMoyenne;
    protected List<LocalDate[]> periodesReservees;

    public Hebergement(String id, String nom, String localisation, double prixParNuit, double noteMoyenne) {
        this.id = id;
        this.nom = nom;
        this.localisation = localisation;
        this.prixParNuit = prixParNuit;
        this.noteMoyenne = noteMoyenne;
        this.periodesReservees = new ArrayList<>();
    }

    public String getNom() {return nom;}
    
    public double getPrixParNuit() {return prixParNuit;}

    public String getLocalisation() {return localisation;}

    public double getNoteMoyenne() {return noteMoyenne;}

    @Override
    public boolean estDisponible(LocalDate dateDebut, LocalDate dateFin) {
        for (LocalDate[] periode : periodesReservees) {
            if (dateDebut.isBefore(periode[1]) && dateFin.isAfter(periode[0])) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void reserver(LocalDate dateDebut, LocalDate dateFin) {
        if (estDisponible(dateDebut, dateFin)) {
            periodesReservees.add(new LocalDate[]{dateDebut, dateFin});
        } else {
            throw new IllegalStateException("Hébergement non disponible pour cette période.");
        }
    }

    @Override
    public void liberer(LocalDate dateDebut, LocalDate dateFin) {
        periodesReservees.removeIf(p -> p[0].equals(dateDebut) && p[1].equals(dateFin));
    }

    @Override
    public int compareTo(Hebergement autre) {
        return Double.compare(this.prixParNuit, autre.prixParNuit);
    }

    public abstract void afficherDetails();

    @Override
    public String toString() {
        return String.format("%s (%s) - %.2f€/nuit - ★ %.1f", nom, localisation, prixParNuit, noteMoyenne);
    }
}
