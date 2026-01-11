public abstract class Herbegement implements Comparable<Herbegement> {
    private String nom, adresse, type, description, equipement, calendrier;//plagheLibre, sommeDuSejuour, enleverReservation
    private int id, prix, noteMoyenne, capaciteMax;

    public Herbegement(String nom , String adresse, String type, String description, String equipement, String calendrier, int id, int prix, int noteMoyenne, int capaciteMax, int superficie) {
        this.nom = nom;
        this.adresse = adresse;
        this.type = type;
        this.description = description;
        this.equipementcalendendrier = equipement;
        this.calendrier = calendrier;
        this.id = id;
        this.prix = prix;
        this.noteMoyenne = noteMoyenne;
        this.capaciteMax = capaciteMax;
    }

    public boolean estDisponible(String dateDebut, String dateFin) {
        for (String periode : calendrier.split(";")) {
            String[] dates = periode.split("-");
            String debut = dates[0];
            String fin = dates[1];
            if (!(dateFin.compareTo(debut) < 0 || dateDebut.compareTo(fin) > 0)) {
                return false;
            }
        }
        return true;
    }

    public int calculerSejour(String dateDebut, String dateFin, int nbPersonnes) {
        int debut = Integer.parseInt(dateDebut);
        int fin = Integer.parseInt(dateFin);
        int jours = (fin - debut);
        return jours * prix * nbPersonnes;
    }

    public void reserver(Client c, Date date){}

    public void annulerReservation(Client c, Date date){}

    public void afficherDetails() {
        System.out.println("Nom: " + nom);
        System.out.println("Adresse: " + adresse);
        System.out.println("Type: " + type);
        System.out.println("Description: " + description);
        System.out.println("Equipement: " + equipement);
        System.out.println("Prix par nuit: " + prix);
        System.out.println("Note moyenne: " + noteMoyenne);
        System.out.println("Capacité maximale: " + capaciteMax);
    }

    public boolean estReservee(Date date) {
        return false;
    }

    //ajout guetters et setters si besoin

}