package ie.cct.gergarage.controller.requests;

import ie.cct.gergarage.model.Appointment;
import ie.cct.gergarage.model.Mech;
import ie.cct.gergarage.model.MechSchedule;

public class SetMechRequest {
    private Mech mech;
    private Appointment appointment;

    public SetMechRequest() {
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public Mech getMech() {
        return mech;
    }
}
