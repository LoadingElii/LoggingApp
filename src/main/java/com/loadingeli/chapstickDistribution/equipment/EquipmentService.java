package com.loadingeli.chapstickDistribution.equipment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
}
