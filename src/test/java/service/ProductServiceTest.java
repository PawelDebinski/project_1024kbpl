package service;

import entity.Boots;
import entity.Cloth;
import entity.Product;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


public class ProductServiceTest {

    private List<Product> products;

    @Before
    public void setup() {
        products = new ArrayList<>();
        products.add(new Cloth(1L, "Jacket", 123.50, 10, "black", 12, "L", "leather"));
        products.add(new Boots(2L, "Boots", 12.99, 5, "green", 22, "40", false));
    }

    @Test
    public void testGetAllProductsPositive() {
        ProductServiceImpl productService = new ProductServiceImpl(products);
        List<Product> testProductsList = productService.getAllProducts();

        assertEquals(products, testProductsList);
    }

    @Test
    public void testGetAllProductsNegative() {
        ProductServiceImpl productService = new ProductServiceImpl(new ArrayList<>(products));
        products.add(new Cloth(3L, "Shirt", 80.00, 3, "blue", 8, "M", "cotton"));
        List<Product> testProductsList = productService.getAllProducts();

        assertNotEquals(products, testProductsList);
    }

    @Test
    public void testGetProductsTotalNumberWithProducts() {

        ProductServiceImpl productService = new ProductServiceImpl(products);
        int productsTotalNumber = productService.getProductsTotalNumber();

        assertEquals(2, productsTotalNumber);
    }

    @Test
    public void testGetProductsTotalNumberWithoutProducts() {
        ProductServiceImpl productService = new ProductServiceImpl();
        int productTotalNumber = productService.getProductsTotalNumber();

        assertEquals(0, productTotalNumber);
    }

    @Test
    public void testGetProductByNameWhenExist() {
        ProductServiceImpl productService = new ProductServiceImpl(products);
        Product productFromTestClass = productService.getProductByName("Jacket");

        assertEquals(products.get(0), productFromTestClass);
    }

    @Test
    public void testGetProductByNameWhenDoesNotExist() {
        ProductServiceImpl productService = new ProductServiceImpl(products);
        Product product = productService.getProductByName("Dress");

        assertNull(product);
    }

    @Test
    public void testIsProductOnStockWhenIs() {
        ProductServiceImpl productService = new ProductServiceImpl(products);
        boolean isProductOnStock = productService.isProductOnStock("Jacket");

        assertTrue(isProductOnStock);
    }

    @Test
    public void testIsProductOnStockWhenIsNot() {
        ProductServiceImpl productService = new ProductServiceImpl(products);
        boolean isProductOnStock = productService.isProductOnStock("Dress");

        assertFalse(isProductOnStock);
    }

    @Test
    public void testDoesProductExistByNameIfExists() {
        ProductServiceImpl productService = new ProductServiceImpl(products);
        boolean isProductExist = productService.isProductExist("Jacket");

        assertTrue(isProductExist);
    }

    @Test
    public void testDoesProductExistByNameIfDoesNotExist() {
        ProductServiceImpl productService = new ProductServiceImpl(products);
        boolean isProductExist = productService.isProductExist("Dress");

        assertFalse(isProductExist);
    }

    @Test
    public void testDoesProductExistByIdIfExists() {
        ProductServiceImpl productService = new ProductServiceImpl(products);
        boolean isProductExist = productService.isProductExist(1L);

        assertTrue(isProductExist);
    }

    @Test
    public void testDoesProductExistByIdIfDoesNotExist() {
        ProductServiceImpl productService = new ProductServiceImpl(products);
        boolean isProductExist = productService.isProductExist(6L);

        assertFalse(isProductExist);
    }

}
