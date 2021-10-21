package kodlamaio.northwind.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;//jpa
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//lombokı import ettim jdk 11ile çalışıyor bu yüzden eclipse silip tekrar yükledim...
@Data
//annotation /derleme anında
@Entity
@Table(name="products")//veritabanında bunun karşılığı productstır.springle bu şekilde kullanılıyor
@AllArgsConstructor    ///tüm özellikleri içeren constructor için 
@NoArgsConstructor 
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="product_id")
	private int id;
	
	//join yaptığım için gerek kalmadı
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
	
	//productlerin bir kategorisi
	@ManyToOne()
	@JoinColumn(name="category_id")
	private Category category;
}
