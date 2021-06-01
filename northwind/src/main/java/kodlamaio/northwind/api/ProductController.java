package kodlamaio.northwind.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.northwind.business.abstracts.ProductService;
import kodlamaio.northwind.core.utilites.results.DataResult;
import kodlamaio.northwind.core.utilites.results.Result;
import kodlamaio.northwind.entities.concretes.Product;
import kodlamaio.northwind.entities.dtos.ProductWithCategoryDto;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	
	private ProductService productService;
	
	@Autowired
	public ProductController(ProductService productService) {
		super();
		this.productService = productService;
	}

	@GetMapping("/getall")
	public DataResult<List<Product>> getAll(){
		return this.productService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Product product) {
		return this.productService.add(product);
	}
	
	@GetMapping("/getByProductName")
	public DataResult<Product> getByProductName(@RequestParam String productName){
		
		return this.productService.getByProductName(productName);
	}
	
	@GetMapping("/getByProductNameAndCategoryId")
	public	DataResult<List<Product>> getByProductNameAndCategoryId(@RequestParam("productName") String productName,@RequestParam("categoryId") int categoryId){
		return this.getByProductNameAndCategoryId(productName,categoryId);
	}
	
	@GetMapping("/getByProductNameContains")
	public 	DataResult<List<Product>> getByProductNameContains(String productName){
		return this.productService.getByProductNameContains(productName);
	}
	
	@GetMapping("/getAllByPage")
	public DataResult<List<Product>> getAll(int pageNo,int pageSize) {
		return this.productService.getAll(pageNo, pageSize);
	}
	
	
	@GetMapping("/getAllDesc")
	public DataResult<List<Product>> getAllSorted() {
		return this.productService.getAllSorted();
	}
	
	@GetMapping("/getProductsDetails")
	DataResult<List<ProductWithCategoryDto>> getProductsDetails(){
		return this.productService.getProductsDetails();
	}

	
}
