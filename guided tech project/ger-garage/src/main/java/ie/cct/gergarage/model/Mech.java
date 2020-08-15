package ie.cct.gergarage.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "mech")
public class Mech {

    @Id
    @Column(name="idmech")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer idmech;

    @Column(name = "namemech")
    private String namemech;

    @JsonIgnore
    @OneToMany(mappedBy = "idsched")
    List<MechSchedule> schedules;

    public Mech() {
    }

    public Integer getIdmech() {
        return idmech;
    }

    public void setIdmech(Integer idmech) {
        this.idmech = idmech;
    }

    public String getNamemech() {
        return namemech;
    }

    public void setNamemech(String namemech) {
        this.namemech = namemech;
    }

    public List<MechSchedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<MechSchedule> schedules) {
        this.schedules = schedules;
    }
}
