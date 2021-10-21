package kodlamaio.northwind.business.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.concretes.Product;
import kodlamaio.northwind.entities.dtos.ProductWithCategoryDto;

public interface ProductService {
	// List<Product> findAll(); //buraya result lazım
	DataResult<List<Product>> getAll(); // dataesult tipinde içinde herhangi bir T barındıran metod
	//sayfalama işlemi
	DataResult<List<Product>> getAll(int pageNumber,int pageSize);
	//istediğim şekilde sırala
	DataResult<List<Product>> getAllSorted();
	Result add(Product product);

	// bunlar da kendi yazdıklarımız
	//ama hepsinin başında DataResult olmalı unutmayalım
	DataResult<Product> getByProductName(String productName);

	DataResult<Product> getByProductNameAndCategoryId(String productName, int categoryId);

	DataResult<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId);

	DataResult<List<Product>> getByCategoryIdIn(List<Integer> categories);

	DataResult<List<Product>> getByProductNameContains(String productName);

	DataResult<List<Product>> getByProductNameStartsWith(String productName);

	DataResult<List<Product>> GetByNameAndCategory(String productName, int categoryId);
	
	DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails();

}
