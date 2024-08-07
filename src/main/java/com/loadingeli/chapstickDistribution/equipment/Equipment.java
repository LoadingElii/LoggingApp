package com.loadingeli.chapstickDistribution.equipment;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Equipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;

    private String brand;
    private Integer equipmentId;

    public Equipment(Long id, String brand, String type, Integer equipmentId) {
        this.id = id;
        this.brand = brand;
        this.type = type;
        this.equipmentId = equipmentId;
    }

    public Equipment() {
    }

    public Equipment(String equipment) {
    }

    public Long getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
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
                ", brand=" + brand + '\'' +
                ", type='" + type + '\'' +
                ", equipmentId='" + equipmentId + '\'' +
                '}';
    }
}
