package kodlamaio.northwind.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.northwind.entities.concretes.Product;
import kodlamaio.northwind.entities.dtos.ProductWithCategoryDto;
//interface interfacei extend eder spring jpa ile rahat edeceğiz
//                                    tablo hangi sınıfta,pkey veri tipi
public interface ProductDao extends JpaRepository<Product,Integer>{
	//hazır bir şekilde jparepository tarafından geliyor
	Product getByProductName(String productName); 
	Product getByProductNameAndCategory_CategoryId(String productName,int categoryId);
	//select * from products where product_name=abc or category_id=1
	List<Product> getByProductNameOrCategory_CategoryId(String productName,int categoryId);
	//select * from products where category_id in (1,2,3,4)
	List<Product> getByCategoryIn(List<Integer> categories);
	List<Product> getByProductNameContains(String productName);
	List<Product> getByProductNameStartsWith(String productName);
	
	
	//Jpa@Query  jpql
	
	@Query("From Product where productName=:productName and category.categoryId=:categoryId")
	List<Product> GetByNameAndCategory(String productName,int categoryId);
	// select * from products where product_name=bisey and category_id=bisey
	
	//dto
	@Query("Select new kodlamaio.northwind.entities.dtos.ProductWithCategoryDto"
			+ "(p.id,p.productName,c.categoryName) "
			+ "From Category c Inner Join c.products p")
	List<ProductWithCategoryDto> getProductWithCategoryDetails();
	//select * from category c inner join product p
	//on c.categoryId=p.categoryId;
	
	
}


//postgresql  config resources kısmında(unutulmasınnnn)