package com.loadingeli.chapstickDistribution.equipment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/equipment")
@CrossOrigin
public class EquipmentController {

    private final EquipmentService equipmentService;

    @Autowired
    EquipmentController(EquipmentService equipmentService) {
        this.equipmentService = equipmentService;
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<Equipment>> getAllEquipment() {
        return ResponseEntity.ok(equipmentService.getAllEquipment());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Optional<Equipment>> getSingleEquipment(@PathVariable(value = "id") Long id) {
        return new ResponseEntity<>(equipmentService.getEquipmentByID(id), HttpStatus.OK);
    }

    @PostMapping(path = "/save")
    public ResponseEntity<Equipment> saveEquipment(@RequestBody Equipment equipment) {
        return new ResponseEntity<>(equipmentService.saveEquipment(equipment), HttpStatus.OK);
    }

    @PutMapping(path = "/update/{id}")
    public ResponseEntity<Equipment> updateEquipment(@PathVariable("id") Long id ,@RequestBody Equipment equipment){
        return new ResponseEntity<>(equipmentService.updateEquipmentByID(id, equipment), HttpStatus.OK);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void deleteEquipment(@PathVariable("id") Long id) {
        equipmentService.deleteEquipmentByID(id);
    }






}
