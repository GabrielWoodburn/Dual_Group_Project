package model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {

	//Variables
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="EMPLOYEE_ID")
	private int employee_Id;
	@Column(name="EMPLOYEE_FIRST")
	private String employee_First;
	@Column(name="EMPLOYEE_LAST")
	private String employee_Last;
	@Column(name="EMPLOYEE_POSITION")
	private String employee_Position;
	
	private List<Animal> animalList;
	
	//Constructors
	public Employee()
	{
		
	}
	
	public Employee(String employee_Position)
	{
		super();
		this.employee_Position = employee_Position;
	}
	
	public Employee(String employee_First, String employee_Last, String employee_Position)
	{
		super();
		this.employee_First = employee_First;
		this.employee_Last = employee_Last;
		this.employee_Position = employee_Position;
	}
	
	//Methods
	public int getEmployee_Id() {
		return employee_Id;
	}

	public void setEmployee_Id(int employee_Id) {
		this.employee_Id = employee_Id;
	}

	public String getEmployee_First() {
		return employee_First;
	}

	public void setEmployee_First(String employee_First) {
		this.employee_First = employee_First;
	}

	public String getEmployee_Last() {
		return employee_Last;
	}

	public void setEmployee_Last(String employee_Last) {
		this.employee_Last = employee_Last;
	}

	public String getEmployee_Position() {
		return employee_Position;
	}

	public void setEmployee_Position(String employee_Position) {
		this.employee_Position = employee_Position;
	}
	@Override
	public String toString() {
		return "Employee [employee_Id=" + employee_Id + ", employee_First=" + employee_First + ", employee_Last="
				+ employee_Last + ", employee_Position=" + employee_Position + ", animalList=" + animalList + "]";
	}
}
	
	
