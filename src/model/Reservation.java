package com.minibooking.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Reservation {
    public enum Statut { EN_ATTENTE, CONFIRMEE, ANNULEE, TERMINEE }

    private String id;
    private Client client;
    private Hebergement hebergement;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private Statut statut;
    private double prixTotal;

    public Reservation(String id, Client client, Hebergement hebergement, LocalDate dateDebut, LocalDate dateFin) {
        this.id = id;
        this.client = client;
        this.hebergement = hebergement;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.statut = Statut.EN_ATTENTE;
        calculerPrixTotal();
    }

    private void calculerPrixTotal() {
        long nbNuits = ChronoUnit.DAYS.between(dateDebut, dateFin);
        double prixBase = nbNuits * hebergement.getPrixParNuit();
        this.prixTotal = prixBase * (1 - client.getReduction());
    }

    public void confirmer() {
        if (hebergement.estDisponible(dateDebut, dateFin)) {
            hebergement.reserver(dateDebut, dateFin);
            this.statut = Statut.CONFIRMEE;
            System.out.println("Réservation " + id + " confirmée pour " + client.getNom());
        } else {
            System.out.println("Echec confirmation: Hébergement non disponible.");
        }
    }

    public void annuler() {
        if (this.statut == Statut.CONFIRMEE) {
            hebergement.liberer(dateDebut, dateFin);
        }
        this.statut = Statut.ANNULEE;
        System.out.println("Réservation " + id + " annulée.");
    }

    @Override
    public String toString() {
        return "Resasultat utilisateur |" + client.getNom() + " -> " + hebergement.getNom() + 
               " | " + dateDebut + " au " + dateFin + 
               " | Statut: " + statut + 
               " | Total: " + String.format("%.2f", prixTotal) + "€";
    }
}
