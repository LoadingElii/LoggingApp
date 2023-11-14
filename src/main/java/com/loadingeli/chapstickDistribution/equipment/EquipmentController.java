package com.loadingeli.chapstickDistribution.equipment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/equipment")
public class EquipmentController {

    private final EquipmentService equipmentService;

    @Autowired
    EquipmentController(EquipmentService equipmentService) {
        this.equipmentService = equipmentService;
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<Equipment>> getAllCustomers() {
        return ResponseEntity.ok(equipmentService.getAllEquipment());
    }
}
