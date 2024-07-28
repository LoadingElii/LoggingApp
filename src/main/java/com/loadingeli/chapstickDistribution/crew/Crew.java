package com.loadingeli.chapstickDistribution.crew;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.loadingeli.chapstickDistribution.employee.Employee;
import com.loadingeli.chapstickDistribution.equipment.Equipment;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Crew {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @OneToMany
    @JoinColumn(name = "employees", referencedColumnName = "id")
    private List<Employee> crewMembers;
    @OneToMany
    @JoinColumn(name = "equipment", referencedColumnName = "id")
    private List<Equipment> crewEquipment;


    public Crew(Long id, String name, List<Employee> crewMembers, List<Equipment> crewEquipment) {
        this.id = id;
        this.name = name;
        this.crewMembers = crewMembers;
        this.crewEquipment = crewEquipment;
    }

    public Crew() {
    }

    public Long getId(){
        return this.id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getCrewMembers() {
        return crewMembers;
    }

    public void setCrewMembers(List<Employee> crewMembers) {
        this.crewMembers = crewMembers;
    }

    public List<Equipment> getCrewEquipment() {
        return crewEquipment;
    }

    public void setCrewEquipment(List<Equipment> crewEquipment) {
        this.crewEquipment = crewEquipment;
    }

    @JsonProperty("crewMembers")
    public void deserializeCrewMembers(List<String> crewMembers) {
        List<Employee> members = new ArrayList<>();
        for (String member:crewMembers) {
            Employee newMember = new Employee(member);
            members.add(newMember);
        }
        this.crewMembers = members;
    }

    @JsonProperty("crewEquipment")
    public void deserializeCrewEquipment(List<String> crewEquipment) {
        List<Equipment> allEquipment = new ArrayList<>();
        for (String equipment:crewEquipment) {
            Equipment newEquipment = new Equipment(equipment);
            allEquipment.add(newEquipment);
        }
        this.crewEquipment = allEquipment;
    }

    @Override
    public String toString() {
        return "Crew{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", crewMembers=" + crewMembers +
                ", crewEquipment=" + crewEquipment +
                '}';
    }
}
