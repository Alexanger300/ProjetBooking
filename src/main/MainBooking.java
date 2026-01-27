package com.minibooking.main;

import com.minibooking.model.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class MainBooking {
    public static void main(String[] args) {
        CollectionHebergements catalogue = new CollectionHebergements();
        Administrateur admin = new Administrateur("ADM01", "Sophie Admin", "sophie@booking.com", "SUPER_ADMIN");
        
        Hebergement h1 = new ChambreHotel("H01", "Hotel Ibis", "Paris", 90.0, 4.2, 102, true);
        Hebergement h2 = new Appartement("A01", "Loft Moderne", "Lyon", 120.0, 4.7, 3, true);
        Hebergement h3 = new Villa("V01", "Villa Sunset", "Nice", 350.0, 4.9, true, 500.0);
        Hebergement h4 = new ChambreHotel("H02", "Hotel Cheap", "Paris", 45.0, 2.5, 12, false);

        catalogue.ajouterHebergement(h1, admin);
        catalogue.ajouterHebergement(h2, admin);
        catalogue.ajouterHebergement(h3, admin);
        catalogue.ajouterHebergement(h4, admin);

        Scanner scanner = new Scanner(System.in);
        
        System.out.println("#############################################");
        System.out.println("#      BIENVENUE SUR MINI-BOOKING           #");
        System.out.println("#############################################");
        
        boolean continuer = true;

        while (continuer) {
            System.out.println("\n---------------- MENU PRINCIPAL ----------------");
            System.out.println("1. Voir tous les hébergements");
            System.out.println("2. Rechercher par ville");
            System.out.println("3. Faire une réservation");
            System.out.println("4. Quitter");
            System.out.print("Votre choix (1-4) : ");
            
            int choix = scanner.nextInt();
            scanner.nextLine(); 

            if (choix == 1) {
                System.out.println("\n--- Liste de tous nos hébergements ---");
                catalogue.afficherTout();
            
            } else if (choix == 2) {
                System.out.print("Entrez le nom de la ville : ");
                String ville = scanner.nextLine();
                List<Hebergement> resultats = catalogue.rechercherParVille(ville);
                
                if (resultats.isEmpty()) {
                    System.out.println("Aucun hébergement trouvé à " + ville);
                } else {
                    System.out.println("Nous avons trouvé " + resultats.size() + " hébergements :");
                    for (Hebergement h : resultats) {
                        h.afficherDetails();
                    }
                }

            } else if (choix == 3) {
                System.out.println("\n--- Nouvelle Réservation ---");
                
                System.out.print("Votre nom : ");
                String nom = scanner.nextLine();
                System.out.print("Votre email : ");
                String email = scanner.nextLine();
                Client client = new NouveauClient("C_USER", nom, email);
                
                System.out.println("Voici la liste pour choisir :");
                catalogue.afficherTout();
                System.out.print("Entrez le NOM EXACT de l'hébergement (ex: Hotel Ibis) : ");
                String nomHebergement = scanner.nextLine();
                
                Hebergement hebergementChoisi = null;
                Hebergement[] tableauLocal = {h1, h2, h3, h4};
                
                for(Hebergement h : tableauLocal) {
                    if(h.getNom().equalsIgnoreCase(nomHebergement)) {
                        hebergementChoisi = h;
                        break;
                    }
                }
                
                if (hebergementChoisi == null) {
                    System.out.println("Erreur : Hébergement non trouvé. Vérifiez l'orthographe.");
                } else {
                    System.out.println("--- Dates de séjour ---");
                    System.out.print("Année (ex: 2024) : ");
                    int annee = scanner.nextInt();
                    System.out.print("Mois (1-12) : ");
                    int mois = scanner.nextInt();
                    while (mois < 1 || mois > 12) {
                        System.out.println("Mois invalide. Réservation annulée. recommencez :");
                        int mois = scanner.nextInt();;
                    }
                    System.out.print("Jour de début : ");
                    int jourDebut = scanner.nextInt();
                    while (jourDebut < 1 || jourDebut > 31) {
                        System.out.println("Jour invalide. Réservation annulée. recommencez :");
                        int jourDebut = scanner.nextInt();;
                    }
                    
                    System.out.print("Combien de nuits ? ");
                    int nbNuits = scanner.nextInt();
                    
                    LocalDate dateDebut = LocalDate.of(annee, mois, jourDebut);
                    LocalDate dateFin = dateDebut.plusDays(nbNuits);
                    
                    Reservation resa = new Reservation("RES_USER", client, hebergementChoisi, dateDebut, dateFin);
                    resa.confirmer(); 
                    
                    System.out.println(resa); 
                }

            } else if (choix == 4) {
                System.out.println("Merci d'avoir utilisé Mini-Booking. À bientôt !");
                continuer = false;
            } else {
                System.out.println("Choix invalide, réessayez.");
            }
        }
        
        scanner.close();
    }
}
