package dev.gaute.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/places")
public class PlaceController {
    @Autowired
    private PlaceService placeService;
    @GetMapping
    public ResponseEntity<List<Place>> allPlaces()
    {
        return new ResponseEntity<List<Place>>(placeService.allPlaces(),HttpStatus.OK);
    }
}
