package com.loadingeli.chapstickDistribution.crew;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CrewService {

    private final CrewRepository crewRepository;

    @Autowired
    CrewService(CrewRepository crewRepository) {
        this.crewRepository = crewRepository;
    }
    public List<Crew> getAllCrews() {
        return crewRepository.findAll();
    }
}
