/**
 * @author Gabriel Woodburn - gwoodburn
 * CIS175 - Spring 2021
 * 2/09/21
 */
package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="animal")
public class ListItem {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	@Column(name="ZOO")
	private String zoo;
	@Column (name="ANIMAL")
	private String animal;
	
	public ListItem() {
		super();
	}

	public ListItem(String zoo, String animal) {
		super();
		this.zoo = zoo;
		this.animal = animal;
	}
	
	public String returnItemDetails() {
		return zoo + ": " + zoo;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getZoo() {
		return zoo;
	}

	public void setZoo(String zoo) {
		this.zoo = zoo;
	}

	public String getAnimal() {
		return animal;
	}

	public void setAnimal(String animal) {
		this.animal = animal;
	}
	
}
