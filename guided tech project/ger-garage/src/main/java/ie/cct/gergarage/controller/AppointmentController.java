package ie.cct.gergarage.controller;


import ie.cct.gergarage.controller.requests.SetMechRequest;
import ie.cct.gergarage.model.*;
import ie.cct.gergarage.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    @Autowired
    AppointmentRepository apprepository;

    @Autowired
    CustomerRepository custrepository;

    @Autowired
    VehicleRepository vehrepository;

    @Autowired
    MechScheduleRepository mechschedrepository;

    @Autowired
    MechRepository mechrepository;

    @PostMapping("/new-mechanic")
    public void newMechanic(@RequestBody Mech mech){
        mechrepository.save(mech);
    }


    @GetMapping("/customer-appointments/{id}")
    public ArrayList<Appointment> customerAppointments(@PathVariable("id") Integer id) {

        Customer customer = custrepository.findByIdcust(id);

        return apprepository.findByCustomer(customer);

    }


    @PostMapping("/new")
    public void newAppointment(@RequestBody Vehicle vehicle,@RequestParam String cmt, String date){

        vehicle.setIdVeh(0);

        //pegamos o vehicle preenchido, e dentro dele tem a info do customer logado
        vehrepository.save(vehicle);

        //aqui salvamos o customer logado em um objeto
        //no vehicle, tinha só o id dele, então pesquisamos no banco pelo id e achamos o objeto completo
        Customer customer = custrepository.findByIdcust(vehicle.getCustomer().getIdCust());


        //novo objeto appointment
        Appointment appointment = new Appointment();

        
        //setamos a foreign key como o customer que foi passado
        appointment.setCustomer(customer);

        //setamos a data como a  data que foi passada
        appointment.setDateAp(date);

        //setamos o comment que foi passado
        appointment.setCmt(cmt);

        //salvamos o appointment criado e inserimos ele atualizado em um obj appointment novo
        Appointment savedAppointment= apprepository.save(appointment);

        MechSchedule mechSchedule = new MechSchedule();
        mechSchedule.setAppointment(savedAppointment);
        mechschedrepository.save(mechSchedule);


    }

    @Transactional
    @DeleteMapping("/delete-appointment")
    public void deleteAppointment(@RequestParam Integer idAp){

        Appointment appointment = new Appointment();
        appointment.setIdAp(idAp);

        apprepository.deleteByIdAp(appointment.getIdAp());

    }


    @GetMapping("/all")
    public ArrayList<Appointment> allAppointments(){

        return apprepository.findAll();

    }


    @GetMapping("/schedule")
    public ArrayList<MechSchedule> schedule(){

        return mechschedrepository.findAll();

    }


    @PutMapping("/set-mech")
    public void setMech(@RequestBody SetMechRequest setMechRequest){
        MechSchedule mechSchedule = mechschedrepository.findByAppointment(setMechRequest.getAppointment());
        mechSchedule.setMech(setMechRequest.getMech());
        mechschedrepository.save(mechSchedule);
    }


    @PutMapping("/edit-price")
    public void editPrice(@RequestBody Appointment appointment){

        apprepository.save(appointment);


    }

    @GetMapping("/all-mechanics")
    public ArrayList<Mech> allMechanics(){
        return  mechrepository.findAll();
    }
    @Transactional
    @DeleteMapping("/delete-mechanic")
    public void deleteMechanic(@RequestParam Integer idMech){

        mechrepository.deleteByIdmech(idMech);


    }

}
