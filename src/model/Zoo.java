package model;

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
import javax.persistence.OneToMany;
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
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, orphanRemoval=true)
	@JoinTable
	  (
	      name="zoo_caretaker",
	      joinColumns={ @JoinColumn(name="ZOO_ID", referencedColumnName="ZOO_ID") },
	      inverseJoinColumns={ @JoinColumn(name="CARETAKER_ID", referencedColumnName="CARETAKER_ID", unique=true) }
	  )
	private List<Caretaker> caretakerList;
	
	
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
	public Zoo(String zoo_name, List<Caretaker> caretakerList)
	{
		super();
		this.zoo_name = zoo_name;
		this.caretakerList = caretakerList;
	}
	
	//Methods
	public int getZoo_Id() {
		return zoo_id;
	}
	public void setZoo_Id(int zoo_id) {
		this.zoo_id = zoo_id;
	}
	public String getZoo_name() {
		return zoo_name;
	}
	public void setZoo_name(String zoo_name) {
		this.zoo_name = zoo_name;
	}
	public List<Caretaker> getCaretakerList() {
		return caretakerList;
	}
	public void setCaretakerList(List<Caretaker> caretakerList) {
		this.caretakerList = caretakerList;
	}
	@Override
	public String toString() {
		return "Zoo [zoo_id=" + zoo_id + ", zoo_name=" + zoo_name + ", caretakerList=" + caretakerList + "]";
	}
}