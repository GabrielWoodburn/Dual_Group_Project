/**  * @author Gabriel Woodburn - gwoodburn  * CIS175 - Spring 2021  * Mar 3, 2021  */
package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="zoolist")
public class ZooList {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	
	@ManyToOne
	@JoinColumn(name="LIST_ID")
	private ListDetails details;
	
	@ManyToOne
	@JoinColumn(name="ITEM_ID")
	private ListItem item;
	//private List<ListItem> itemsOnList = new ArrayList<ListItem>();

	public ZooList() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ListDetails getDetails() {
		return details;
	}

	public void setDetails(ListDetails details) {
		this.details = details;
	}

	public ListItem getItem() {
		return item;
	}

	public void setItem(ListItem item) {
		this.item = item;
	}

	@Override
	public String toString() {
		return "ZooList [id=" + id + ", details=" + details + ", item=" + item.toString() + "]";
	}
	
}
