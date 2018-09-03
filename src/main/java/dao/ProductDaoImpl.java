package dao;

import api.ProductDao;
import entity.Product;
import entity.parser.ProductParser;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {

    // == fields ==
    private final String fileName;
    private final String productType;

    // == constructors ==
    public ProductDaoImpl(String fileName, String productType) {
        this.fileName = fileName;
        this.productType = productType;
    }

    // == public methods ==
    @Override
    public void saveProduct(Product product) {
        List<Product> products = getAllProducts();
        products.add(product);
        saveProducts(products);
    }

    @Override
    public void saveProducts(List<Product> products) {
        try(PrintWriter pw = new PrintWriter( new FileOutputStream(fileName, false))) {
            for(Product product: products) {
                pw.write(product.toString() + "\n");
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found " + e.getMessage());
        }
    }

    @Override
    public void removeProductById(Long productId) {
        List<Product> products = getAllProducts();

        for(Product product : products) {
            if(product.getId().equals(productId)) {
                products.remove(product);
            }
            saveProducts(products);
        }
    }

    @Override
    public void removeProductByName(String productName) {
        List<Product> productList = getAllProducts();
        for(Product product : productList) {
            if(product.getProductName().equals(productName)) {
                productList.remove(product);
            }
            saveProducts(productList);
        }
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> productList = new ArrayList<>();
        try(BufferedReader bw = new BufferedReader(new FileReader(fileName))) {
            String line;
            while((line = bw.readLine()) != null) {
                Product product = ProductParser.convertStringToProduct(line, productType);
                if(product != null) {
                    productList.add(product);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found " + e.getMessage());
        } catch (IOException e) {
            e.getMessage();
        }
        return productList;
    }


    @Override
    public Product getProductById(Long productId) {
        List<Product> productList = getAllProducts();

        for(Product product : productList) {
            if(product.getId().equals(productId)) {
                return product;
            }
        }
        return null;
    }

    @Override
    public Product getProductByProductName(String productName) {
        List<Product> productList = getAllProducts();

        for(Product product : productList) {
            if(product.getProductName().equals(productName)) {
                return product;
            }
        }
        return null;
    }
}
