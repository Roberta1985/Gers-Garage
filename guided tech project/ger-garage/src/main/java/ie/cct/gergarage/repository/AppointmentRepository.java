package ie.cct.gergarage.repository;

import ie.cct.gergarage.model.Appointment;
import ie.cct.gergarage.model.Customer;
import org.springframework.data.repository.Repository;


import java.util.ArrayList;
import java.util.Optional;


public interface AppointmentRepository extends Repository<Appointment, Integer> {
Appointment save(Appointment ap);
ArrayList<Appointment> findByCustomer(Customer customer);
ArrayList<Appointment> findAll();
Appointment findByIdAp(Integer id);
void deleteByIdAp(Integer id);


}
