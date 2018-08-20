package api;

import entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();
    int getProductsTotalNumber();
    Product getProductByName(String productName);
    boolean isProductOnStock(String productName);
    boolean isProductExist(String productName);
    boolean isProductExist(Long productId);

}

