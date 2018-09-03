package api;

import entity.Product;

import java.util.List;

public interface ProductDao {

    void saveProduct(Product product);
    void saveProducts(List<Product> products);

    void removeProductById(Long productId);
    void removeProductByName(String productName);

    List<Product> getAllProducts();
    Product getProductById(Long productId);
    Product getProductByProductName(String productName);
}
