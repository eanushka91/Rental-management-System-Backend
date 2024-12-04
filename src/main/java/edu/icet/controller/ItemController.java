package edu.icet.controller;

import edu.icet.dto.Item;
import edu.icet.dto.Rental;
import edu.icet.service.ItemService;
import edu.icet.service.RentalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item")
@RequiredArgsConstructor
@CrossOrigin
public class ItemController {
    private final ItemService service;

    @GetMapping("/get-all")
    public List<Item> getItem(){
        return service.getAll();
    }

    @PostMapping("/add-item")
    @ResponseStatus(HttpStatus.CREATED)
    public void addItem(@RequestBody Item item){
        service.addItem(item);
    }

    @GetMapping("/search-by-id/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Item getitemById(@PathVariable Integer id){
        return service.searchItemById(id);
    }

    @DeleteMapping("/delete-by-id/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteItemById(@PathVariable Integer id){
        service.deleteItemById(id);
    }

    @PutMapping("/update-item")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateItem(@RequestBody Item item){
        service.updateItemById(item);
    }
}
