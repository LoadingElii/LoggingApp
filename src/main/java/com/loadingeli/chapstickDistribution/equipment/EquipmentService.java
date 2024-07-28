package com.loadingeli.chapstickDistribution.equipment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EquipmentService {

    private final EquipmentRepository equipmentRepository;

    @Autowired
    EquipmentService(EquipmentRepository equipmentRepository) {
        this.equipmentRepository = equipmentRepository;
    }
    public List<Equipment> getAllEquipment() {
        return equipmentRepository.findAll();
    }

    public Optional<Equipment> getEquipmentByID(Long id) {
        return equipmentRepository.findById(id);
    }

    public Equipment saveEquipment(Equipment equipment) {
        return equipmentRepository.save(equipment);
    }

    public Equipment updateEquipmentByID(Long id, Equipment equipment) {
        Equipment foundedEquipment = equipmentRepository.getReferenceById(id);

        foundedEquipment.setBrand(equipment.getBrand());
        foundedEquipment.setType(equipment.getType());

        return foundedEquipment;
    }

    public void deleteEquipmentByID(Long id) {
        equipmentRepository.deleteById(id);
    }

    public List<Equipment> getEquipmentByIds(List<Long> equipmentIDS) {
         return equipmentRepository.findAllById(equipmentIDS);
    }
}
