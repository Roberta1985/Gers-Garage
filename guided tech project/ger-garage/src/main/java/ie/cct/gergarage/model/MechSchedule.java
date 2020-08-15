package ie.cct.gergarage.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name="mechschedule")
public class MechSchedule {
    @Id
    @Column(name="idsched")
    @JsonIgnore
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer idsched;

    @ManyToOne
    @JoinColumn(name = "idmech")
    private Mech mech;

    @ManyToOne
    @JoinColumn(name = "idap")
    private Appointment appointment;

    public MechSchedule() {
    }

    public Integer getIdsched() {
        return idsched;
    }

    public void setIdsched(Integer idsched) {
        this.idsched = idsched;
    }

    public Mech getMech() {
        return mech;
    }

    public void setMech(Mech mech) {
        this.mech = mech;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }
}
