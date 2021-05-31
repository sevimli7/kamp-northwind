package kodlamaIo.northwind.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaIo.northwind.business.abstracts.ProductService;
import kodlamaIo.northwind.core.utilities.results.DataResult;
import kodlamaIo.northwind.core.utilities.results.Result;

import kodlamaIo.northwind.entities.concretes.Product;
import kodlamaIo.northwind.entities.dtos.ProductWithCategoryDto;

@RestController   //sen bir controllersın dedik.böylece diğer yerler bizim java kodlarımızı okuyabilir.
@RequestMapping("/api/products")  //dış dünyadan bize  kodlama.io/api/products isteği gelirse, onu requestmapping ile karşılarız
public class ProductsController {
	
	private ProductService productService; //business i injections yaptık buraya.
	
	@Autowired//productManager burası sayesinde arkada newleniyor.
	public ProductsController(ProductService productService) {
		super();
		this.productService = productService;
		}

	@GetMapping("/getall")
	public DataResult< List<Product>> getAll(){
		
		return this.productService.getAll();
		
		}
	@PostMapping("/add")
	public Result add(@RequestBody Product product) {  //requestBody products tablosundaki columnnamelere göre data oluşturur
		return this.productService.add(product);
		}
	
	@GetMapping("/getbyproductname")
	public DataResult<Product> getByProductName(@RequestParam String productName){
		
		return this.productService.getByProductName(productName);

		}
	
	@GetMapping("/getByProductNameAndCategory")
	public DataResult<Product> getByProductNameAndCategory(@RequestParam("productName")String productName , @RequestParam("categoryId") int categoryId ){
		return this.productService.getByProductNameAndCategory(productName, categoryId);
		}
	
	
	  @GetMapping("/getByProductNameAndCategoryId") 
	  public DataResult<List<Product>> getByProductNameOrCategoryId(@RequestParam String productName,@RequestParam int categoryId){
		  return this.productService.getByProductNameOrCategory(productName, categoryId); 
		  }
	  
	  @GetMapping("/getByCategoryIdIn") 
	  public DataResult<List<Product>> getByCategoryIdIn( @RequestParam List<Integer> categories){ 
		  return this.productService.getByCategoryIn(categories); 
		  }
	  
	  @GetMapping("/getByProductNameContains") 
	  public DataResult<List<Product>> getByProductNameContains(@RequestParam String productName){ 
		  return this.productService.getByProductNameContains(productName); 
		  }
	 
	  @GetMapping("/getByProductNameStartsWith") 
	  public DataResult<List<Product>> getByProductNameStartsWith(@RequestParam String productName){
		  return this.productService.getByProductNameStartsWith(productName); 
		  }
	  
	  @GetMapping("/getByNameAndCategory") 
	  public DataResult<List<Product>> getByNameAndCategory(@RequestParam String productName,@RequestParam int categoryId){ 
		  return this.productService.getByNameAndCategory(productName, categoryId); 
		  }
	 
	  @GetMapping("/getProductWithCategoryDetails")
	  public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails() {

			return this.productService.getProductWithCategoryDetails();
			
		  }
	  
	  @GetMapping("/getAllByPage")
	   DataResult<List<Product>> getAll(int pageNo,int pageSize){
		  return this.productService.getAll(pageNo,pageSize);
	  }
	  
	  @GetMapping("/getAllDesc")
	   DataResult<List<Product>> getAllSorted(){
		  return this.productService.getAllSorted();
	  }
	  
	 
}
