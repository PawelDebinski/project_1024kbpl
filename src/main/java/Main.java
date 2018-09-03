import dao.ProductDaoImpl;
import entity.Boots;
import entity.Cloth;
import entity.Product;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {



        List<Product> products = new ArrayList<>();
        products.add(new Cloth(1L, "Jacket", 111.00, 9, "white", 7, "M", "leather"));
        products.add(new Cloth(2L, "Jacket2", 123.50, 10, "black", 12, "L", "leather"));
        ProductDaoImpl productClothDao = new ProductDaoImpl("src\\main\\resources\\cloth.txt", "CLOTH");
        productClothDao.saveProducts(products);

        List<Product> products2 = new ArrayList<>();
        products2.add(new Boots(3L, "Boots", 10.49, 5, "yellow", 4, "40", false));
        products2.add(new Boots(4L, "Boots2", 12.99, 5, "green", 22, "40", true));
        ProductDaoImpl productBootsDao = new ProductDaoImpl("src\\main\\resources\\boots.txt", "BOOTS");
        productBootsDao.saveProducts(products2);



//        System.out.println();
//        System.out.println(" Loaded products ==============================================");
//        products = productClothDao.getAllProducts();
//        for(Product product: products) {
//            System.out.println(product.toString());
//        }
//
//        System.out.println();
//        System.out.println(" Added product ==============================================");
//        Boots boots = new Boots(5L, "Boots3", 8.99, 5, "white", 3, "38", false);
//        productClothDao.saveProduct(boots);
//        products = productClothDao.getAllProducts();
//        for(Product product: products) {
//            System.out.println(product.toString());
//        }
//
//        System.out.println();
//        System.out.println(" Removed product by Id ==============================================");
//        productClothDao.removeProductById(3L);
//        products = productClothDao.getAllProducts();
//        for(Product product: products) {
//            System.out.println(product.toString());
//        }
//
//        System.out.println();
//        System.out.println(" Removed product by Name ==============================================");
//        productClothDao.removeProductByName("Jacket");
//        products = productClothDao.getAllProducts();
//        for(Product product: products) {
//            System.out.println(product.toString());
//        }
//
//        System.out.println();
//        System.out.println("Get product by id: " + productClothDao.getProductById(2L));
//        System.out.println("Get product by name: " + productClothDao.getProductByProductName("Boots3"));
//
//        System.out.println();
//        System.out.println("===================================================");
//        System.out.println("Users =============================================");
//
//        List<User> users = new ArrayList<>();
//        users.add(new User(1L, "admin", "admin"));
//        users.add(new User(2L, "pablo", "admin"));
//        users.add(new User(3L, "marco", "admin"));
//
//        UserDaoImpl userDao = new UserDaoImpl("src\\main\\resources\\users.txt");
//
//        userDao.saveUsers(users);
//        for(User user: users) {
//            System.out.println(user.toString());
//        }
//
//        System.out.println();
//        System.out.println(" Loaded users ==============================================");
//        users = userDao.getAllUsers();
//        for(User user: users) {
//            System.out.println(user.toString());
//        }
//
//        System.out.println();
//        System.out.println(" Added user ==============================================");
//        User user4 = new User(4L, "Michael", "admin");
//        userDao.saveUser(user4);
//        users = userDao.getAllUsers();
//        for(User user: users) {
//            System.out.println(user.toString());
//        }
//
//        System.out.println();
//        System.out.println(" Removed user by Id ==============================================");
//        userDao.removeUserById(3L);
//        users = userDao.getAllUsers();
//        for(User user: users) {
//            System.out.println(user.toString());
//        }
//
//        System.out.println();
//        System.out.println(" Removed user by Login ==============================================");
//        userDao.removeUserByLogin("pablo");
//        users = userDao.getAllUsers();
//        for(User user: users) {
//            System.out.println(user.toString());
//        }
//
//        System.out.println();
//        System.out.println("Get user by id: " + userDao.getUserById(1L));
//        System.out.println("Get user by login: " + userDao.getUserByLogin("Michael"));

    }
}
