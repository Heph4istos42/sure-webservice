package com.example.surewebservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class PlaceController {

    @Autowired
    private PlaceService placeService;

    @GetMapping("/help")
    public String allo() {
        return "TODO: - add a doku";
    }

    @GetMapping("/places")
    public List<Place> list() {
        return placeService.listAll();
    }

    @GetMapping("/places/{id}")
    public ResponseEntity<Place> get(@PathVariable Integer id) {
        try {
            Place place = placeService.get(id);
            return new ResponseEntity<Place>(place, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Place>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/places")
    public void add(@RequestBody Place place) {
        placeService.save(place);
    }

    @PutMapping("/places/{id}")
    public ResponseEntity<?> update(@RequestBody Place place, @PathVariable Integer id) {
        try {
            Place existProduct = placeService.get(id);
            placeService.save(place);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/places/{id}")
    public void delete(@PathVariable Integer id) {
        placeService.delete(id);
    }
}
