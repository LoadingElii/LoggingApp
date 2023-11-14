package com.loadingeli.chapstickDistribution.equipment;

import jakarta.persistence.*;

@Entity
public class Equipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private Integer equipmentId;

    public Equipment(Long id, String type, Integer equipmentId) {
        this.id = id;
        this.type = type;
        this.equipmentId = equipmentId;
    }

    public Equipment() {
    }

    public Long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(Integer equipmentId) {
        this.equipmentId = equipmentId;
    }

    @Override
    public String toString() {
        return "Equipment{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", equipmentId='" + equipmentId + '\'' +
                '}';
    }
}
