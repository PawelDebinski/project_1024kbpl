package service;

import api.ProductDao;
import api.ProductService;
import dao.ProductDaoImpl;
import entity.Product;

import java.util.List;

public class ProductServiceImpl implements ProductService {

    // == fields ==
    private static ProductServiceImpl instance = null;
    private ProductDao productDao = new ProductDaoImpl("products.txt", "PRODUCT");

    // == constructors ==
    private ProductServiceImpl() {
    }

    // == public methods ==
    public static ProductServiceImpl getInstance() {
        if (instance == null) {
            instance = new ProductServiceImpl();
        }
        return instance;
    }

    @Override
    public List<Product> getAllProducts() {
        return productDao.getAllProducts();

    }

    @Override
    public int getProductsTotalNumber() {
        return getAllProducts().size();
    }

    @Override
    public Product getProductByName(String productName) {
        return productDao.getProductByProductName(productName);
    }

    @Override
    public boolean isProductOnStock(String productName) {
        for (Product product : productDao.getAllProducts()) {
            if(isProductExist(productName) && product.getProductCount() > 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isProductExist(String productName) {
        if (productDao.getProductByProductName(productName) == null) {
            return false;
        }
        return true;
    }

    @Override
    public boolean isProductExist(Long productId) {
        if (productDao.getProductById(productId) == null) {
            return false;
        }
        return true;
    }

}
