package service;

import api.ProductService;
import entity.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService {

    // == fields ==
    List<Product> products;

    // == constructors ==
    public ProductServiceImpl(List<Product> products) {
        this.products = products;
    }

    public ProductServiceImpl() {
        this.products = new ArrayList<>();
    }

    // == public methods ==
    @Override
    public List<Product> getAllProducts() {

        return products;

    }

    @Override
    public int getProductsTotalNumber() {
        return products.size();
    }

    @Override
    public Product getProductByName(String productName) {

        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getProductName() == productName) {
                return products.get(i);
            }
        }
        return null;
    }

    @Override
    public boolean isProductOnStock(String productName) {

        for (Product product : products) {
            if (isProductExist(productName) && (product.getProductCount() > 0)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isProductExist(String productName) {
        for (Product product : products) {
            if (product.getProductName() == productName) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isProductExist(Long productId) {

        for (Product product : products) {
            if (product.getId() == productId) {
                return true;
            }
        }
        return false;
    }
}
