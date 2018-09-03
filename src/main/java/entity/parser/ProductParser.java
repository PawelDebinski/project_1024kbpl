package entity.parser;

import entity.Boots;
import entity.Cloth;
import entity.Product;

public class ProductParser {

    public static Product convertStringToProduct(String line, String productType) {

        switch (productType) {

            case "PRODUCT":
                return stringToProduct(line);

            case "CLOTH":
                return stringToCloth(line);

            case "BOOTS":
                return stringToBoots(line);

            default:
                return null;
        }
    }

    private static Product stringToProduct(String line) {
        String[] productData = line.split(Product.PRODUCT_SEPARATOR);

        Long id = Long.parseLong(productData[0]);
        String productName = productData[1];
        double price = Double.parseDouble(productData[2]);
        double weight = Double.parseDouble(productData[3]);
        String color = productData[4];
        int productCount = Integer.parseInt(productData[5]);

        return new Product(id, productName, price, weight, color, productCount);
    }

    private static Boots stringToBoots(String line) {
        String[] bootsData = line.split(Product.PRODUCT_SEPARATOR);

        Long id = Long.parseLong(bootsData[0]);
        String productName = bootsData[1];
        double price = Double.parseDouble(bootsData[2]);
        double weight = Double.parseDouble(bootsData[3]);
        String color = bootsData[4];
        int productCount = Integer.parseInt(bootsData[5]);
        String size = bootsData[6];
        boolean isNaturalSkin = Boolean.parseBoolean(bootsData[7]);

        return new Boots(id, productName, price, weight, color, productCount, size, isNaturalSkin);
    }

    private static Cloth stringToCloth(String line) {
        String[] clothData = line.split(Product.PRODUCT_SEPARATOR);

        long id = Long.parseLong(clothData[0]);
        String productName = clothData[1];
        double price = Double.parseDouble(clothData[2]);
        double weight = Double.parseDouble(clothData[3]);
        String color = clothData[4];
        int productCount = Integer.parseInt(clothData[5]);
        String size = clothData[6];
        String material = clothData[7];

        return new Cloth(id, productName, price, weight, color, productCount, size, material);
    }
}
