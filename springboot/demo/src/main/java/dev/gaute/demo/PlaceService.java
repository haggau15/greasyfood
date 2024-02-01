package dev.gaute.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaceService {
    @Autowired
    private PlaceRepository place;
    public List<Place> allPlaces ()
    {
        System.out.println("Oah");
        return place.findAll();
    }
}
