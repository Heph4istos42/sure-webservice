package com.example.surewebservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PlaceService {

    @Autowired
    private PlaceRepository placeRepo;

    public List<Place> listAll() {
        return placeRepo.findAll();
    }

    public void save(Place place) {
        placeRepo.save(place);
    }

    public Place get(Integer id) {
        return placeRepo.findById(id).get();
    }

    public void delete(Integer id) {
        placeRepo.deleteById(id);
    }
}
