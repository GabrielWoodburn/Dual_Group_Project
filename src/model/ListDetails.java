/**  * @author Gabriel Woodburn - gwoodburn  * CIS175 - Spring 2021  * Mar 3, 2021  */
package model;

import java.time.LocalDate;
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
@Table(name="list_details")
public class ListDetails {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="LIST_ID")
	private int id;
	@Column(name="LIST_NAME")
	private String listName;
	@Column(name="ANIMAL_DATE")
	private LocalDate animalDate;
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="ZOO_ID")
	private Zoo zoo;
	@OneToMany(cascade=CascadeType.PERSIST, fetch=FetchType.EAGER)
	@JoinTable(name="items_on_list", joinColumns= {@JoinColumn(name="list_id", referencedColumnName="list_id")}, inverseJoinColumns= {@JoinColumn(name="id", referencedColumnName="ID", unique=true)})
	private List<ListItem> listOfItems;

	public ListDetails() {
		
	}

	public ListDetails(int id, String listName, LocalDate animalDate, Zoo zoo, List<ListItem> listOfItems) {
		super();
		this.id = id;
		this.listName = listName;
		this.animalDate = animalDate;
		this.zoo = zoo;
		this.listOfItems = listOfItems;
	}

	public ListDetails(String listName, LocalDate animalDate, Zoo zoo, List<ListItem> listOfItems) {
		super();
		this.listName = listName;
		this.animalDate = animalDate;
		this.zoo = zoo;
		this.listOfItems = listOfItems;
	}

	public ListDetails(String listName, LocalDate tripDate, Zoo zoo) {
		super();
		this.listName = listName;
		this.animalDate = tripDate;
		this.zoo = zoo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getListName() {
		return listName;
	}

	public void setListName(String listName) {
		this.listName = listName;
	}

	public LocalDate getAnimalDate() {
		return animalDate;
	}

	public void setAnimalDate(LocalDate tripDate) {
		this.animalDate = tripDate;
	}

	public Zoo getZoo() {
		return zoo;
	}


	public void setZoo(Zoo zoo) {
		this.zoo = zoo;
	}

	public List<ListItem> getListOfItems() {
		return listOfItems;
	}

	public void setListOfItems(List<ListItem> listOfItems) {
		this.listOfItems = listOfItems;
	}

	@Override
	public String toString() {
		return "ListDetails [id=" + id + ", listName=" + listName + ", animalDate=" + animalDate + ", zoo=" + zoo
				+ ", listOfItems=" + listOfItems + "]";
	}
	
}
