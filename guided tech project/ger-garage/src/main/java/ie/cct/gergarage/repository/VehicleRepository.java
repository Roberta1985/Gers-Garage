package ie.cct.gergarage.repository;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.data.repository.Repository;

import ie.cct.gergarage.model.Customer;
import ie.cct.gergarage.model.Vehicle;

public interface VehicleRepository extends Repository<Vehicle,Integer>{
	Vehicle save(Vehicle vehicle);
	Optional<Vehicle> findAllByCustomer(Customer customer);
	ArrayList<Vehicle> findAll();
}
