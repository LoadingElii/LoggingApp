package com.loadingeli.chapstickDistribution.crew;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/crew")
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

}
