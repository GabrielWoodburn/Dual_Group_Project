package model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="zoo")
public class Zoo {
	//Variables
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ZOO_ID")
	private int zoo_id;
	@Column(name="ZOO_NAME")
	private String zoo_name;
	
	private List<Employee> employeeList;
	
	//Constructors
	public Zoo()
	{
		super();
		
	}
	public Zoo(String zoo_name)
	{
		super();
		this.zoo_name = zoo_name;
	}
	
	//Methods
	public int getZoo_id() {
		return zoo_id;
	}
	public void setZoo_id(int zoo_id) {
		this.zoo_id = zoo_id;
	}
	public String getZoo_name() {
		return zoo_name;
	}
	public void setZoo_name(String zoo_name) {
		this.zoo_name = zoo_name;
	}
	@Override
	public String toString() {
		return "Zoo [zoo_id=" + zoo_id + ", zoo_name=" + zoo_name + ", employeeList=" + employeeList + "]";
	}
}
