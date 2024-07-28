package com.loadingeli.chapstickDistribution.dataLoader;

import com.loadingeli.chapstickDistribution.crew.Crew;
import com.loadingeli.chapstickDistribution.crew.CrewRepository;
import com.loadingeli.chapstickDistribution.employee.Employee;
import com.loadingeli.chapstickDistribution.employee.EmployeeRepository;
import com.loadingeli.chapstickDistribution.equipment.Equipment;
import com.loadingeli.chapstickDistribution.equipment.EquipmentRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataLoader implements ApplicationRunner {
    private final EmployeeRepository employeeRepository;
    private final EquipmentRepository equipmentRepository;
    private final CrewRepository crewRepository;

    private List<Employee> members;
    private List<Equipment> equipment;


    public DataLoader(EmployeeRepository employeeRepository,
                      EquipmentRepository equipmentRepository,
                      CrewRepository crewRepository, List<Employee> members, List<Equipment> equipment) {
        this.employeeRepository = employeeRepository;
        this.equipmentRepository = equipmentRepository;
        this.crewRepository = crewRepository;
        this.members = members;
        this.equipment = equipment;
    }
    @Override
    public void run(ApplicationArguments args) throws Exception {
        employeeRepository.save(new Employee(
                1L,"Eli Brown",
                "El1234","deking@email.com",
                0,"Software Engineer"
        ));
        employeeRepository.save(new Employee(
                2L,"Quan Brown",
                "Qu1234","QUANng@email.com",
                0,"Truck Driver"
        ));
        employeeRepository.save(new Employee(
                3L,"Kraysheian Brown",
                "Kr1234","kray@email.com",
                0,"Salon Owner"
        ));

        equipmentRepository.save(new Equipment(1L,"CAT","Backhoe-01",22));
        equipmentRepository.save(new Equipment(2L,"Komatsu","Excavator-01",33));
        equipmentRepository.save(new Equipment(3L,"CAT","Bobcat-01",13));


        members.add(employeeRepository.getReferenceById(1L));
        members.add(employeeRepository.getReferenceById(2L));

        equipment.add(equipmentRepository.getReferenceById(1L));
        equipment.add(equipmentRepository.getReferenceById(2L));

        crewRepository.save(new Crew(1L, "Water Crew-01",members,equipment));

    }
}
