package dao;

import api.ProductDao;
import entity.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {

    // == fields ==
    String fileName;

    // == constructors ==
    public ProductDaoImpl(String fileName) {
        this.fileName = fileName;
    }

    // == public methods ==
    @Override
    public void saveProduct(Product product) {
        try(PrintWriter pw = new PrintWriter( new FileOutputStream(fileName, true))) {
            pw.write(product.toString() + "\n");
        } catch (FileNotFoundException e) {
            System.out.println("File not found " + e.getMessage());
        }
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
        List<Product> productList = getAllProducts();
        for(Product product : productList) {
            if(product.getId().equals(productId)) {
                productList.remove(product);
                saveProducts(productList);
                break;
            }
        }
    }

    @Override
    public void removeProductByName(String productName) {
        List<Product> productList = getAllProducts();
        for(Product product : productList) {
            if(product.getProductName().equals(productName)) {
                productList.remove(product);
                saveProducts(productList);
                break;
            }
        }
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> productList = new ArrayList<>();
        try(BufferedReader bw = new BufferedReader(new FileReader(fileName))) {
            String line;
            while((line = bw.readLine()) != null) {
                String[] array = line.split(",");
                Product product = new Product(Long.parseLong(array[0]), array[1], Double.parseDouble(array[2]),
                        Double.parseDouble(array[3]), array[4], Integer.parseInt(array[5]));
                productList.add(product);
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
