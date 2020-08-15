package ie.cct.gergarage.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.lang.String;
import java.util.List;


@Entity
@Table(name = "appointment")
public class Appointment {

    @Id
    @Column(name="idap")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer idAp;

    @Column(name = "service")
    private String service;

    @Column(name = "dateap")
    private String dateAp;

    @Column(name = "cmt")
    private String cmt;

    @Column(name = "price")
    private Double price;

    @Column(name = "addcost")
    private Double addCost;

    @Column(name = "state")
    private String state;

    @JsonIgnore
    @OneToMany(mappedBy = "idsched")
    List<MechSchedule> schedules;

    @ManyToOne
    @JoinColumn(name = "idcust")

    private Customer customer;

    public Appointment() {
    }

    public Integer getIdAp() {
        return idAp;
    }

    public void setIdAp(Integer idAp) {
        this.idAp = idAp;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getDateAp() {
        return dateAp;
    }

    public void setDateAp(String dateAp) {
        this.dateAp = dateAp;
    }

    public String getCmt() {
        return cmt;
    }

    public void setCmt(String cmt) {
        this.cmt = cmt;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getAddCost() {
        return addCost;
    }

    public void setAddCost(Double addCost) {
        this.addCost = addCost;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<MechSchedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<MechSchedule> schedules) {
        this.schedules = schedules;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer idCust) {
        this.customer = idCust;
    }
}
