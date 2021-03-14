package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="caretaker")
public class Caretaker {

	//Variables
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CARETAKER_ID")
	private int caretaker_Id;
	@Column(name="CARETAKER_FIRST")
	private String caretaker_First;
	@Column(name="CARETAKER_LAST")
	private String caretaker_Last;
	@Column(name="HIREDATE")
	private LocalDate hireDate;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, orphanRemoval=true)
	@JoinTable
	  (
	      name="caretaker_animal",
	      joinColumns={ @JoinColumn(name="CARETAKER_ID", referencedColumnName="CARETAKER_ID") },
	      inverseJoinColumns={ @JoinColumn(name="ANIMAL_ID", referencedColumnName="ANIMAL_ID", unique=true) }
	  )
	private List<Animal> animalList;
	
	//Constructors
	public Caretaker()
	{
		super();
	}
	
	public Caretaker(String caretaker_First, String caretaker_Last)
	{
		super();
		this.caretaker_First = caretaker_First;
		this.caretaker_Last = caretaker_Last;
		this.hireDate = LocalDate.now();
	}
	public Caretaker(String caretaker_First, String caretaker_Last, LocalDate date)
	{
		super();
		this.caretaker_First = caretaker_First;
		this.caretaker_Last = caretaker_Last;
		this.hireDate = date;
	}
	public Caretaker(String caretaker_First, String caretaker_Last, LocalDate hireDate, List<Animal>animalList)
	{
		super();
		this.caretaker_First = caretaker_First;
		this.caretaker_Last = caretaker_Last;
		this.hireDate = hireDate;
		this.animalList = animalList;
		
	}
	
	//Methods
	public int getCaretaker_Id() {
		return caretaker_Id;
	}

	public void setCaretaker_Id(int employee_Id) {
		this.caretaker_Id = employee_Id;
	}

	public String getCaretaker_First() {
		return caretaker_First;
	}

	public void setCaretaker_First(String caretaker_First) {
		this.caretaker_First = caretaker_First;
	}

	public String getCaretaker_Last() {
		return caretaker_Last;
	}

	public void setCaretaker_Last(String caretaker_Last) {
		this.caretaker_Last = caretaker_Last;
	}

	public List<Animal> getAnimalList() {
		return animalList;
	}

	public void setAnimalList(List<Animal> animalList) {
		this.animalList = animalList;
	}
	public LocalDate getHireDate() {
		return hireDate;
	}

	public void setHireDate(LocalDate hireDate) {
		this.hireDate = hireDate;
	}

	@Override
	public String toString() {
		return "Caretaker [caretaker_Id=" + caretaker_Id + ", caretaker_First=" + caretaker_First + ", caretaker_Last="
				+ caretaker_Last + ", hireDate=" + hireDate + ", animalList=" + animalList + "]";
	}
		
}
	
	
