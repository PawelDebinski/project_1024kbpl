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
    public void saveProduct(Product product) throws IOException {
        List<Product> products = getAllProducts();
        products.add(product);
        saveProducts(products);
    }

    @Override
    public void saveProducts(List<Product> products) throws FileNotFoundException {
        try(PrintWriter pw = new PrintWriter( new FileOutputStream(fileName, false))) {
            for(Product product: products) {
                pw.write(product.toString() + "\n");
            }
        }
    }

    @Override
    public void removeProductById(Long productId) throws IOException {
        List<Product> products = getAllProducts();

        for(Product product : products) {
            if(product.getId().equals(productId)) {
                products.remove(product);
            }
            saveProducts(products);
        }
    }

    @Override
    public void removeProductByName(String productName) throws IOException {
        List<Product> productList = getAllProducts();
        for(Product product : productList) {
            if(product.getProductName().equals(productName)) {
                productList.remove(product);
            }
            saveProducts(productList);
        }
    }

    @Override
    public List<Product> getAllProducts() throws IOException {
        List<Product> productList = new ArrayList<>();
        try(BufferedReader bw = new BufferedReader(new FileReader(fileName))) {
            String line;
            while((line = bw.readLine()) != null) {
                Product product = ProductParser.convertStringToProduct(line, productType);
                if(product != null) {
                    productList.add(product);
                }
            }
        }
        return productList;
    }

}
