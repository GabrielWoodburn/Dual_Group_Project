package model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="animal")
public class Animal {
	
	//Variables
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ANIMAL_ID")
	private int animal_Id;
	@Column(name="ANIMAL_NAME")
	private String animal_Name;
	@Column(name="ANIMAL_AGE")
	private int animal_Age;

	//Constructors
	public Animal()
	{
		super();
	}
	
	public Animal(String animal_Name, int animal_Age)
	{
		super();
		this.animal_Name = animal_Name;
		this.animal_Age = animal_Age;
	}

	//Methods
	public int getAnimal_Id() {
		return animal_Id;
	}

	public void setAnimal_Id(int animal_Id) {
		this.animal_Id = animal_Id;
	}

	public String getAnimal_Name() {
		return animal_Name;
	}

	public void setAnimal_Name(String animal_Name) {
		this.animal_Name = animal_Name;
	}

	public int getAnimal_Age() {
		return animal_Age;
	}

	public void setAnimal_Age(int animal_Age) {
		this.animal_Age = animal_Age;
	}

	@Override
	public String toString() {
		return "Animal [animal_Id=" + animal_Id + ", animal_Name=" + animal_Name + ", animal_Age=" + animal_Age + "]";
	}
	
}
