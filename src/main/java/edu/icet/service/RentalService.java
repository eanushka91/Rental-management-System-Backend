package edu.icet.service;

import edu.icet.dto.Rental;

import java.util.List;

public interface RentalService {
    List<Rental> getAll();
    void addRental(Rental rental);
    void deleteRentalById(Integer id);
    Rental searchRentalById(Integer id);
    void updateRentalById(Rental rental);
}
