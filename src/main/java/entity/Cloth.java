package entity;

public class Cloth extends Product{

    // == fields
    private String size;
    private String material;

    // == constructors ==
    public Cloth(long id, String productName, double price, double weight, String color, int productCount, String size, String material) {
        super(id, productName, price, weight, color, productCount);
        this.size = size;
        this.material = material;
    }

    // == public methods ==
    public String getSize() {
        return size;
    }

    public String getMaterial() {
        return material;
    }

    @Override
    public String toString() {
        return super.toString() +
                PRODUCT_SEPARATOR + size +
                PRODUCT_SEPARATOR + material;
    }
}
