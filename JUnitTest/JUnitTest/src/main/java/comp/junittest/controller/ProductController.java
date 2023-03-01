package comp.junittest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	public ProductController addProduct(@RequestBody Product product) {
		productService.
		
		return service;
	}
	
	@GetMapping
	public List<Product> findAllProducts() {
		return service.getProducts();
	}
	
	@GetMapping("/{id}")
	public Product findProductById(@PathVariable int id) {
		
	}
	
	@PutMapping("/update/{id}")
	public Product updateProduct(@RequestBody Product product , @PathVariable int id) {
		
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteProductString(@PathVariable int id) {
		return service.deleteProduct(id);
	}
	
	
	
}
