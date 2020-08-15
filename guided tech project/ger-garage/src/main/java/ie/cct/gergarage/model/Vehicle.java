package ie.cct.gergarage.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "vehicle")
public class Vehicle {


	@Id 
	@Column(name="idveh")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonIgnore
	private Integer idVeh;


	//FOREIGN KEY

	//MANY TO ONE, ESSE VEHICLE TEM UM DONO CUSTOMER
	@ManyToOne

	//ONDE AS COLUNAS SE JUNTAM, O NOME DA FOREIGN KEY
	@JoinColumn(name = "idcust")


	private Customer customer;






	@Column(name="vehicle_type")
	private String vehicleType;
	@Column(name = "vehicle_make")
	private String vehicleMake;
	@Column(name = "vehicle_engine_type")
	private String vehicleEngineType;
	@Column(name = "vehicle_license")
	private String vehicleLicense;
	
	public Vehicle(Integer idveh, Customer customer, String vehicleType, String vehicleMake, String vehicleEngineType,
			String vehicleLicense) {
		super();
		this.idVeh = idveh;
		this.customer = customer;
		this.vehicleType = vehicleType;
		this.vehicleMake = vehicleMake;
		this.vehicleEngineType = vehicleEngineType;
		this.vehicleLicense = vehicleLicense;
	}
	public Vehicle() {
		super();
	}
	public int getIdVeh() {
		return  idVeh;
	}
	public void setIdVeh(Integer idVeh) {
		this.idVeh = idVeh;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	public String getVehicleMake() {
		return vehicleMake;
	}
	public void setVehicleMake(String vehicleMake) {
		this.vehicleMake = vehicleMake;
	}
	public String getVehicleEngineType() {
		return vehicleEngineType;
	}
	public void setVehicleEngineType(String vehicleEngineType) {
		this.vehicleEngineType = vehicleEngineType;
	}
	public String getVehicleLicense() {
		return vehicleLicense;
	}
	public void setVehicleLicense(String vehicleLicense) {
		this.vehicleLicense = vehicleLicense;
	}
	
}
