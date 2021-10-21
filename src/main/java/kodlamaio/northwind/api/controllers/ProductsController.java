package kodlamaio.northwind.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.northwind.business.abstracts.ProductService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.core.utilities.results.SuccessDataResult;
import kodlamaio.northwind.entities.concretes.Product;
import kodlamaio.northwind.entities.dtos.ProductWithCategoryDto;

@RestController // restcontroller da springden
@RequestMapping("/api/products") // dış dünyadan istekte bulunulursa örn kodlamaio/api/products diye
//bu controller karar veriyor
@CrossOrigin
public class ProductsController {
	// veri istekleri vardır frontend tarafından verilen

	// buraya autowired desen yine çalışır ama birden fazla servis olabilir
	private ProductService productService;

	@Autowired // autowired benim yerime newleyecek tarayarak olmasa ProductManager yazardık
	public ProductsController(ProductService productService) {
		super();
		this.productService = productService;
	}

	// getall isteği için bu metod çalışacak
	@GetMapping("/getall")
	public DataResult<List<Product>> getAll() {

		return this.productService.getAll(); // productservicedan çekiyoruz yani business kısmından

	}

	@PostMapping("/add")
	public Result add(@RequestBody Product product) {
		return this.productService.add(product); // gelen requestin bodysi var diyoruz post işlemi için....
		// istek yapıyor Productı eşleştiriyor yani
	}

	@GetMapping("/getByProductName")
	public DataResult<Product> getByProductName(@RequestParam String productName) // requestparam productnamei okumasını
																					// sağlıor
	{
		return this.productService.getByProductName(productName);
	}

	@GetMapping("/getByProductNameAndCategoryId")
	public DataResult<Product> getByProductNameAndCategoryId(@RequestParam("productName") String productName,
			@RequestParam("categoryId ") int categoryId) {
		return this.productService.getByProductNameAndCategoryId(productName, categoryId);
	}

	@GetMapping("/getByProductNameOrCategoryId")
	public DataResult<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId) {

		return this.productService.getByProductNameOrCategoryId(productName, categoryId);
	}

	@GetMapping("/getByProductNameContains")
	public DataResult<List<Product>> getByProductNameContains(@RequestParam String productName) // içerisinde yazdığımız
																								// harfler bulunan
																								// ürünleri alıyoruz
	{
		return this.productService.getByProductNameContains(productName);
	}

	@GetMapping("/getAllByPage")
	public DataResult<List<Product>> getAll(int pageNumber, int pageSize) {
		return this.productService.getAll(pageNumber, pageSize);

	}
	@GetMapping("/getAllDesc")
	public DataResult<List<Product>> getAllSorted() {
		return this.productService.getAllSorted();
		
	}
	@GetMapping("/getProductWithCategoryDetails")
	public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails() {
		// TODO Auto-generated method stub
		return this.productService.getProductWithCategoryDetails();
	}
	// backendlerin birbiriyle anlaşması için api
	// dış dünyaya açılacak olan kısım

}
