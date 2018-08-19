package entity;

public class Boots extends Product{
    private String size;
    private boolean isNaturalSkin;

    public Boots(String id, String productName, double price, double weight, String color, int productCount, String size, boolean isNaturalSkin) {
        super(id, productName, price, weight, color, productCount);
        this.size = size;
        this.isNaturalSkin = isNaturalSkin;
    }

    public String getSize() {
        return size;
    }

    public boolean isNaturalSkin() {
        return isNaturalSkin;
    }

    @Override
    public String toString() {
        return super.toString() +
                " size='" + size + "\'" +
                " isNaturalSkin='" +isNaturalSkin +'\'';
    }
}
