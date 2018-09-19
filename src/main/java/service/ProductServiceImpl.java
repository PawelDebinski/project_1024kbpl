package service;

import api.ProductDao;
import api.ProductService;
import dao.ProductDaoImpl;
import entity.Product;

import java.io.IOException;
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
    public List<Product> getAllProducts() throws IOException {
        return productDao.getAllProducts();

    }

    @Override
    public int getProductsTotalNumber() throws IOException {
        return getAllProducts().size();
    }

    @Override
    public Product getProductByName(String productName) throws IOException {
        List<Product> products = getAllProducts();

        for (Product product : products
        ) {
            boolean isFoundProduct = product.getProductName().equals(productName);
            if (isFoundProduct) {
                return product;
            }

        }

        return null;
    }

    public Product getProductById(Long productId) throws IOException {
        List<Product> products = getAllProducts();


        for (Product product : products
        ) {
            boolean isFoundProduct = product.getId().equals(productId);
            if (isFoundProduct) {
                return product;
            }

        }

        return null;
    }

    @Override
    public boolean isProductOnStock(String productName) {
        try {
            for(Product product : getAllProducts()) {
                if (isProductExist(productName) && product.getProductCount() > 0) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean isProductExist(String productName) {
        Product product = null;

        try {
            product = getProductByName(productName);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (product == null) return false;

        return true;
    }

    @Override
    public boolean isProductExist(Long productId) {
        Product product = null;

        try {
            product = getProductById(productId);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (product == null) return false;

        return true;
    }

    @Override
    public boolean saveProduct(Product product) {
        try {
            if(productValidator.isValidate(product)) {
                productDao.saveProduct(product);
            }
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());;
        }
        return true;
    }
}
