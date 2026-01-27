package com.minibooking.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CollectionHebergements {
    private List<Hebergement> hebergements;

    public CollectionHebergements() {
        this.hebergements = new ArrayList<>();
    }

    public void ajouterHebergement(Hebergement h, Administrateur admin) {
        if (admin != null) {
            hebergements.add(h);
            System.out.println("Hebergement ajouté: " + h.getNom());
        } else {
            System.out.println("Erreur: Droit administrateur requis.");
        }
    }

    public void supprimerHebergement(Hebergement h, Administrateur admin) {
        if (admin != null && admin.peutSupprimer()) {
            if (hebergements.remove(h)) {
                System.out.println("Hebergement supprimé: " + h.getNom());
            } else {
                System.out.println("Hebergement introuvable.");
            }
        } else {
            System.out.println("Erreur: Droits insuffisants ou admin null.");
        }
    }

    public List<Hebergement> rechercherParVille(String ville) {
        return hebergements.stream()
                .filter(h -> h.getLocalisation().equalsIgnoreCase(ville))
                .collect(Collectors.toList());
    }

    public List<Hebergement> rechercherDisponibles(LocalDate debut, LocalDate fin) {
        return hebergements.stream()
                .filter(h -> h.estDisponible(debut, fin))
                .collect(Collectors.toList());
    }

    public void trierParPrix() {
        Collections.sort(hebergements);
    }

    public void trierParNoteDecroissant() {
        hebergements.sort(Comparator.comparingDouble(Hebergement::getNoteMoyenne).reversed());
    }

    public void afficherTout() {
        System.out.println("--- Liste des Hébergements ---");
        for (Hebergement h : hebergements) {
            h.afficherDetails();
        }
        System.out.println("------------------------------");
    }

    public Hebergement get(int index) {
        if (index >= 0 && index < hebergements.size()) return hebergements.get(index);
        return null;
    }
    
    public int size() {
        return hebergements.size();
    }
}
