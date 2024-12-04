package edu.icet.controller;

import edu.icet.dto.Rental;
import edu.icet.service.RentalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rental")
@RequiredArgsConstructor
@CrossOrigin
public class RentController {
    private final RentalService service;

    @GetMapping("/get-all")
    public List<Rental> getRental(){
        return service.getAll();
    }

    @PostMapping("/add-rental")
    @ResponseStatus(HttpStatus.CREATED)
    public void addRental(@RequestBody Rental rental){
        service.addRental(rental);
    }

    @GetMapping("/search-by-id/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Rental getrentalById(@PathVariable Integer id){
        return service.searchRentalById(id);
    }

    @DeleteMapping("/delete-by-id/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteRentalById(@PathVariable Integer id){
        service.deleteRentalById(id);
    }

    @PutMapping("/update-rental")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateRental(@RequestBody Rental rental){
        service.updateRentalById(rental);
    }
}
