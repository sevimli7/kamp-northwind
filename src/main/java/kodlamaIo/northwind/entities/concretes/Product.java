package kodlamaIo.northwind.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="products")
@AllArgsConstructor
@NoArgsConstructor
public class Product  {
	
	@Id //buranın id alanının burası olduğunu
	@GeneratedValue(strategy=GenerationType.IDENTITY) //id alanının nasıl oluştuğunu 
	@Column(name="product_id") //id alanının tablodaki adını gösterir
	private int id;
	
	//@Column(name="category_id")
	//private int categoryId;
	
	@Column(name="product_name")
	private String productName;
	
	@Column(name="unit_price")
	private double unitPrice;
	
	@Column(name="units_in_stock")
	private short unitsInStock;
	
	@Column(name="quantity_per_unit")
	private String quantityPerUnit;
	
	@ManyToOne() //burada ilişkili olduğu tablonun ne olduğu ve ilişkilerinin nasıl olduğunu tanımladık
	@JoinColumn(name="category_id")
	private Category category;

	
	
}
