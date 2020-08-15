package ie.cct.gergarage.repository;

import ie.cct.gergarage.model.Appointment;
import ie.cct.gergarage.model.Mech;
import ie.cct.gergarage.model.MechSchedule;
import org.springframework.data.repository.Repository;


import java.util.ArrayList;

public interface MechScheduleRepository extends Repository<MechSchedule, Integer> {
    MechSchedule save(MechSchedule mechSchedule);
    ArrayList<MechSchedule> findAll();


    MechSchedule findByAppointment(Appointment appointment);
}
