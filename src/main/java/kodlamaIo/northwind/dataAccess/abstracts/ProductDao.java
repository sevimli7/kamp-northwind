package kodlamaIo.northwind.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaIo.northwind.entities.concretes.Product;
import kodlamaIo.northwind.entities.dtos.ProductWithCategoryDto;

public interface ProductDao extends JpaRepository<Product,Integer>{
	
	Product getByProductName(String productName); //where kullanıldı gibi
	Product getByProductNameAndCategory_CategoryId(String productName, int categoryId); // where
	
	List<Product> getByProductNameOrCategory_CategoryId(String productName,int categoryId); //Or kullanıldı
	List<Product> getByCategory_CategoryIdIn(List<Integer> categories);
	List<Product> getByProductNameContains(String productName); // ürün adına göre sorgu
	List<Product> getByProductNameStartsWith(String productName);
	
	@Query("From Product where productName=:productName and categoryId=:categoryId")//jpql ile sorgu yapmak
	List<Product> getByNameAndCategory_CategoryId(String productName,int categoryId);
	//select * from product where product_name=bişey and category_id=birşey
	
	@Query("Select new kodlamaIo.northwind.entities.dtos.ProductWithCategoryDto(p.id,p.productName,c.categoryName)"
			+ " From Category c Inner Join c.products p")//jpql de entityleri kullanıyoruz. db tabllarını değil!
	List<ProductWithCategoryDto> getProductWithCategoryDetails();
	
	//select p.productId, p.productName,c.categoryName from Category c inner join Product p
	//on c.categoryId=p.categoryId
	
	
	
	//select * from product where category_id in(1,2,3,4) categorisi 1,2,3 veya 4 olanları getir demek sql de

}


//jpa da  crud operasyonları için tanımlama yapılmasına gerek yok.çünkü hazır gelir. ama yukarıdaki
// gibi sadece sutunlar ile sorgu yapılacak ise mutlaka get ile başlanarak yazılmalıdır. gerisin jpa halleder :)
//column isimlerine göre veri istedik.

// jpql ile sorgu yaparken db deki tabloyu değil, kendi entitimizdeki özelliklerin isimlerini kullanırız! 

//from tüm alanları, select ise istediiğimiz bazı alanları çekmek için kullanırız