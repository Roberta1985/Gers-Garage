package ie.cct.gergarage.controller;


import ie.cct.gergarage.model.Customer;
import ie.cct.gergarage.model.Vehicle;
import ie.cct.gergarage.repository.CustomerRepository;
import ie.cct.gergarage.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sun.print.CUPSPrinter;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/customer")


//http://localhost:8080/customer
public class CustomerController {


    @Autowired
    CustomerRepository custrepository;

    @Autowired
    VehicleRepository vehrepository;

    @PostMapping("/signup")

    //@RequestBody pede um objeto vindo do frontend em JSON (JavaScript Object Notation)
    public void signUp(@RequestBody Customer customer) {
        custrepository.save(customer);
    }


    //@RequestParam pede valores pra fazer algo no back, nesse caso a gente pede login e senha
    @GetMapping("/signin")
    public Optional<Customer> signIn(@RequestParam String username, String password) {
        return custrepository.findByUsernameAndPw(username, password);
    }

    @GetMapping("/all")
    public ArrayList<Customer> allCustomers(){

        return custrepository.findAll();


    }

    @GetMapping("/login-admin")
    public Customer loginAdmin(@RequestParam String login, String password){

        Customer admin = custrepository.findByUsernameAndPw(login,password).get();
        if(admin.isAdminaccess()){
            return admin;
        } else{
            return null;
        }

    }

    @GetMapping("/all-vehicles")
    public ArrayList<Vehicle> allVehicles(){

        return vehrepository.findAll();


    }

}
