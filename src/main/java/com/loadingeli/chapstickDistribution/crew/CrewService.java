package com.loadingeli.chapstickDistribution.crew;

import com.loadingeli.chapstickDistribution.employee.Employee;
import com.loadingeli.chapstickDistribution.employee.EmployeeService;
import com.loadingeli.chapstickDistribution.equipment.Equipment;
import com.loadingeli.chapstickDistribution.equipment.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CrewService {

    private final CrewRepository crewRepository;
    private final EmployeeService employeeService;
    private final EquipmentService equipmentService;



    @Autowired
    CrewService(CrewRepository crewRepository, EmployeeService employeeService, EquipmentService equipmentService) {
        this.crewRepository = crewRepository;
        this.employeeService = employeeService;
        this.equipmentService = equipmentService;
    }
    public List<Crew> getAllCrews() {
        return crewRepository.findAll();
    }

    public Crew getCrewByID(Long id) {
        return  crewRepository.getReferenceById(id);
    }

    public Crew saveCrew(Crew crew) {
        crew.setCrewMembers(getCrewMembersFromRepo(crew.getCrewMembers()));
        crew.setCrewEquipment(getCrewEquipmentFromRepo(crew.getCrewEquipment()));

        return crewRepository.save(crew);
    }


    private List<Employee> getCrewMembersFromRepo(List<Employee> selectEmployees) {
        List<Long> employeesIDS = new ArrayList<>();
        selectEmployees.forEach(employee -> employeesIDS.add(employee.getId()));

       return employeeService.getEmployeesById(employeesIDS);
    }

    private List<Equipment> getCrewEquipmentFromRepo(List<Equipment> crewEquipment) {
        List<Long> equipmentIDS = new ArrayList<>();
        crewEquipment.forEach(equipment -> equipmentIDS.add(equipment.getId()));

        return equipmentService.getEquipmentByIds(equipmentIDS);
    }
    public Crew updateCrewByID(Long id, Crew crew) {
        Crew foundedCrew = crewRepository.getReferenceById(id);

        foundedCrew.setName(crew.getName());
        foundedCrew.setCrewMembers(crew.getCrewMembers());
        foundedCrew.setCrewEquipment(crew.getCrewEquipment());

        return foundedCrew;
    }

    public void deleteCrewByID(Long id) {
        crewRepository.deleteById(id);
    }
}
