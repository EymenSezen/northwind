package kodlamaio.northwind.business.concretes;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlamaio.northwind.business.abstracts.ProductService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.core.utilities.results.SuccessDataResult;
import kodlamaio.northwind.core.utilities.results.SuccessResult;
import kodlamaio.northwind.dataAccess.abstracts.ProductDao;
import kodlamaio.northwind.entities.concretes.Product;
import kodlamaio.northwind.entities.dtos.ProductWithCategoryDto;

@Service // annotation
public class ProductManager implements ProductService {

	private ProductDao pdao; ////// REFERANs enjeksiyon

	@Autowired // spring arka planda buna karşılık instancei üretiyor.projeyi tarıyor
	public ProductManager(ProductDao pdao) {
		super();
		this.pdao = pdao;
	}

	@Override
	public DataResult<List<Product>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Product>>(this.pdao.findAll(), "Data Listelendi");
		// bütün datayı getir //productdaodan çekiyoruz o da
		// hibernate ile çalışıyor
		// data access kısmından hepsini al yani
	}

	@Override
	public Result add(Product product) {
		// TODO Auto-generated method stub
		this.pdao.save(product);
		return new SuccessResult("Ürün eklendi");
	}

	@Override
	public DataResult<Product> getByProductName(String productName) {
		// TODO Auto-generated method stub

		return new SuccessDataResult<Product>(this.pdao.getByProductName(productName), "Data Listelendi");
	}

	@Override
	public DataResult<Product> getByProductNameAndCategoryId(String productName, int categoryId) {
		//business codes gelecek
		return new SuccessDataResult<Product>(this.pdao.getByProductNameAndCategory_CategoryId(productName, categoryId),
				"Data Listelendi");
	}

	@Override
	public DataResult<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Product>>(this.pdao.getByProductNameOrCategory_CategoryId(productName, categoryId),
				"Data Listelendi");
	}

	@Override
	public DataResult<List<Product>> getByCategoryIdIn(List<Integer> categories) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Product>>(this.pdao.getByCategoryIn(categories), "Data Listelendi");
	}

	@Override
	public DataResult<List<Product>> getByProductNameContains(String productName) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Product>>(this.pdao.getByProductNameContains(productName), "Data Listelendi");

	}

	@Override
	public DataResult<List<Product>> getByProductNameStartsWith(String productName) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Product>>(this.pdao.getByProductNameStartsWith(productName),
				"Data Listelendi");
	}

	@Override
	public DataResult<List<Product>> GetByNameAndCategory(String productName, int categoryId) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Product>>(this.pdao.GetByNameAndCategory(productName, categoryId),
				"Data Listelendi");
	}

	@Override
	public DataResult<List<Product>> getAll(int pageNumber, int pageSize) {
		// TODO Auto-generated method stub
		Pageable pageable=PageRequest.of(pageNumber-1, pageSize);  //0dan başladığı için pageNo
		return new SuccessDataResult<List<Product>>(this.pdao.findAll(pageable).getContent(),"Data Listelendi"); //getcontenti unutma
	}



	@Override
	public DataResult<List<Product>> getAllSorted() {
		// TODO Auto-generated method stub
		Sort sort=Sort.by(Sort.Direction.DESC,"productName");//asc adan zye
		return new SuccessDataResult<List<Product>>(this.pdao.findAll(sort),"Data Listelendi");//sorta göre sıralama
	}

	@Override
	public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails() {
		// TODO Auto-generated method stub
		return new SuccessDataResult(this.pdao.getProductWithCategoryDetails(),"Data Listelendi");
	}

}
