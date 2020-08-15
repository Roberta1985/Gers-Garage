package ie.cct.gergarage.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity 
@Table(name = "customer")
public class Customer {


	//PRIMARY KEY
	@Id

	//MAPEIA QUAL COLUNA O ATRIBUTO PERTENCE
	@Column(name="idcust")

	//FAZ COM QUE O ATRIBUTO POSSA NÃO ESTAR PRESENTE NO JSON DE REQUEST/RESPONSE
	@JsonIgnore

	//AVISA QUE O BANCO QUE GERA ESSE ATRIBUTO, E COMO ELE GERA
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idcust;


	@JsonIgnore

	//UM CUSTOMER TEM UMA LISTA DE VEHICLES
	//NO VEHICLE, O ATRIBUTO QUE REPRESENTA A FOREIGN KEY SE CHAMA "customer"
	@OneToMany(mappedBy="customer")
	private List<Vehicle> vehicles;

	@JsonIgnore
	@OneToMany(mappedBy="customer")
	private List<Appointment> appointments;


	//MAPEIA QUAL COLUNA ESSE ATRIBUTO PERTENCE
	@Column(name = "username")
	private String username;

	@Column(name = "pw")
	private String pw;
	@Column(name="fullname")
	private String fullName;
	@Column(name = "email")

	private String email;
	@Column(name="phonenum")
	private String phoneNum;
	@Column(name="adminaccess")
	private boolean adminaccess;
	

	public Customer(Integer idCust, List<Vehicle> vehicles, String pw, String fullName, String email, String phoneNum,
					boolean adminaccess, String username) {
		super();
		this.idcust = idCust;
		this.vehicles = vehicles;
		this.pw = pw;
		this.fullName = fullName;
		this.email = email;
		this.phoneNum = phoneNum;
		this.adminaccess = adminaccess;
		this.username = username;
	}
	public Customer() {
		super();
	}
	public Integer getIdcust() {
		return idcust;
	}
	public void setIdcust(Integer idcust) {
		this.idcust = idcust;
	}
	public List<Vehicle> getVehicles() {
		return vehicles;
	}
	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public boolean isAdminaccess() {
		return adminaccess;
	}
	public void setAdminaccess(boolean adminaccess) {
		this.adminaccess = adminaccess;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getIdCust() {
		return idcust;
	}

	public void setIdCust(Integer idCust) {
		this.idcust = idCust;
	}

	public List<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}
}
