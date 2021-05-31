package kodlamaIo.northwind.business.abstracts;

import java.util.List;


import kodlamaIo.northwind.core.utilities.results.DataResult;
import kodlamaIo.northwind.core.utilities.results.Result;
import kodlamaIo.northwind.entities.concretes.Product;
import kodlamaIo.northwind.entities.dtos.ProductWithCategoryDto;

public interface ProductService {
	DataResult<List<Product>> getAll();
	DataResult<List<Product>> getAll(int pageNo, int pageSize);//sayfalama
	DataResult<List<Product>> getAllSorted();
	
	Result add(Product product);
	
	DataResult<Product> getByProductName(String productName); //where kullanıldı gibi
	DataResult<Product> getByProductNameAndCategory(String productName, int categoryId); // where
	
	DataResult<List<Product>> getByProductNameOrCategory(String productName,int categoryId); //Or kullanıldı
	DataResult<List<Product>> getByCategoryIn(List<Integer> categories);
	DataResult<List<Product>> getByProductNameContains(String productName); // ürün adına göre sorgu
	DataResult<List<Product>> getByProductNameStartsWith(String productName);
	
	DataResult<List<Product>> getByNameAndCategory(String productName,int categoryId); //jpql ile srgu
	
	DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails();
	
}
