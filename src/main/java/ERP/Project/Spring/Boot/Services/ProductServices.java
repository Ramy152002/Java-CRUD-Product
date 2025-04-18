package ERP.Project.Spring.Boot.Services;

import ERP.Project.Spring.Boot.Repository.ProductRepository;
import ERP.Project.Spring.Boot.entity.Product;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServices {
    @Autowired
    private ProductRepository productRepository;
    public Product CreateProduct(Product product){
        return productRepository.save(product);
    }

    public List<Product> GetAllProducts(){
        return productRepository.findAll();
    }

    public Product GetById(Long id){
        return productRepository.findById(id).orElseThrow(()->new RuntimeException("product not found"));
    }

/*    public Product UpdateProduct(Long id, Product product){

        Optional<Product> product1 = productRepository.findById(id);

        product1.get().setName(product.getName());
        product1.get().setCategory(product.getCategory());
        product1.get().setPrice(product.getPrice());

        return productRepository.save(product);
    }*/
public Product updateProduct(Long id, Product product) {
    Optional<Product> existingProductOptional = productRepository.findById(id);

    if (existingProductOptional.isPresent()) {
        Product existingProduct = existingProductOptional.get();
        existingProduct.setName(product.getName());
        existingProduct.setCategory(product.getCategory());
        existingProduct.setPrice(product.getPrice());

        return productRepository.save(existingProduct);
    } else {
        // Handle the case where the product is not found
        throw new EntityNotFoundException("Product with id " + id + " not found");
    }
}

    public String DeleteProduct(Long id){
        productRepository.deleteById(id);
        return "Product deleted";

    }




}
