package entity;

public class Boots extends Product{

    // == fields
    private String size;
    private boolean isNaturalSkin;

    // == constructors ==
    public Boots(Long id, String productName, double price, double weight, String color, int productCount, String size, boolean isNaturalSkin) {
        super(id, productName, price, weight, color, productCount);
        this.size = size;
        this.isNaturalSkin = isNaturalSkin;
    }

    // == public methods ==
    public String getSize() {
        return size;
    }

    public boolean isNaturalSkin() {
        return isNaturalSkin;
    }

    @Override
    public String toString() {
        return super.toString() +
                PRODUCT_SEPARATOR + size +
                PRODUCT_SEPARATOR + isNaturalSkin;
    }
}
