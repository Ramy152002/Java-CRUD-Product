package ERP.Project.Spring.Boot.Controller;


import ERP.Project.Spring.Boot.Services.ProductServices;
import ERP.Project.Spring.Boot.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductServices productService;

    @GetMapping("/{id}")
    public Product GetById(@PathVariable Long id){
        return productService.GetById(id);
    }

    @GetMapping
    public List<Product> GetAll(){
        return productService.GetAllProducts();
    }

    @PostMapping
    public Product CreateProduct(@RequestBody Product product){
        return productService.CreateProduct(product);
    }

    @PutMapping("/{id}")
    public Product Update(@PathVariable Long id,@RequestBody Product product){
        return productService.updateProduct(id,product);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){
        return productService.DeleteProduct(id);
    }
}