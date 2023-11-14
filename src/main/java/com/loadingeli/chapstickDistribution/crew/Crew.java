package com.loadingeli.chapstickDistribution.crew;

import com.loadingeli.chapstickDistribution.employee.Employee;
import com.loadingeli.chapstickDistribution.equipment.Equipment;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Crew {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany
    private List<Employee> crewMembers;
    @OneToMany
    private List<Equipment> crewEquipment;


    public Crew(Long id, List<Employee> crewMembers, List<Equipment> crewEquipment) {
        this.id = id;
        this.crewMembers = crewMembers;
        this.crewEquipment = crewEquipment;
    }

    public Crew() {
    }

    public Long getId(){
        return this.id;
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
}
