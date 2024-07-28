package com.loadingeli.chapstickDistribution.crew;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/crew")
@CrossOrigin
public class CrewController {

    private final CrewService crewService;

    @Autowired
    CrewController(CrewService crewService) {
        this.crewService = crewService;
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<Crew>> getAllCrews() {
        return ResponseEntity.ok(crewService.getAllCrews());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Crew> getCrew(@PathVariable("id") Long id) {
        return new ResponseEntity<>(crewService.getCrewByID(id), HttpStatus.OK);
    }

    @PostMapping(path = "/save")
    public ResponseEntity<Crew> saveCrew(@RequestBody Crew crew) {
        System.out.println("crew received from frontend " + crew);
        return new ResponseEntity<>(crewService.saveCrew(crew), HttpStatus.OK); }

    @PutMapping(path = "/update/{id}")
    public ResponseEntity<Crew> updateCrew(@PathVariable("id") Long id, @RequestBody Crew crew) {
        return new ResponseEntity<>(crewService.updateCrewByID(id, crew), HttpStatus.OK);
    }

    @DeleteMapping(path = "delete/{id}")
    public void deleteCrew(@PathVariable("id") Long id) {
        crewService.deleteCrewByID(id);
    }

}
