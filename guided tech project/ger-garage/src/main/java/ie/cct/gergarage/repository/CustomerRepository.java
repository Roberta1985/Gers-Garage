package ie.cct.gergarage.repository;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.data.repository.Repository;

import ie.cct.gergarage.model.Customer;

public interface CustomerRepository extends Repository<Customer,Integer>{
Customer save(Customer customer);
ArrayList<Customer> findAll();
Customer findByIdcust(Integer id);
Optional<Customer> findByUsernameAndPw(String username, String pw);
}
