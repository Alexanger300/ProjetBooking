package com.minibooking.model;

import java.time.LocalDate;

public interface Reservable {
    boolean estDisponible(LocalDate dateDebut, LocalDate dateFin);
    void reserver(LocalDate dateDebut, LocalDate dateFin);
    void liberer(LocalDate dateDebut, LocalDate dateFin);
}
