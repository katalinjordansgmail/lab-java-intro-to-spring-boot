package com.ironhack.repository;

import com.ironhack.model.Employee;
import com.ironhack.model.Patient;
import com.ironhack.model.enums.Status;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PatientRepositoryTest {
    private Patient patient1 = new Patient();

    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private EmployeeRepository employeeRepository;

    @BeforeEach
    void setUp() {
        Employee employee1 = new Employee(123,"cardiology", "John Smith", Status.OFF);
        employeeRepository.save(employee1);

        List<Patient> patients = new ArrayList<>();
        Date birthDate = new Date(1989, 6, 11);
        patient1.setPatientId(123);
        patient1.setName("Juan Garcia");
        patient1.setDateOfBirth(birthDate);
        patient1.setAdmittedBy(employee1);
        patients.add(patient1);
        Patient patient2 = new Patient(456, "Marc Williams", birthDate, employee1);
        patients.add(patient2);
        Patient patient3 = new Patient(789, "Eva Rodriguez", birthDate, employee1);
        patients.add(patient3);
        patientRepository.saveAll(patients);
    }

    @AfterEach
    void tearDown() {
        patientRepository.deleteAll();
        patientRepository.flush();
        employeeRepository.deleteAll();
        employeeRepository.flush();
    }

    @Test
    public void testFindAll() {
        List<Patient> patients = patientRepository.findAll();
        assertEquals(3, patients.size());
    }

    @Test
    public void testFindByPatientId_Positive() {
        Optional<Patient> patient = patientRepository.findByPatientId(123);
        assertTrue(patient.isPresent());
        assertEquals(patient1, patient.get());
    }

    @Test
    public void testFindByPatientId_Negative() {
        Optional<Patient> patient = patientRepository.findByPatientId(321);
        assertFalse(patient.isPresent());
    }


}

//    List<Patient> findAllByDateOfBirthRange(Date startDate, Date endDate);
//    List<Patient> findAllByAdmittedBy_Department(String department);
//    List<Patient> findAllByAdmittedBy_StatusOFF();