package flowers;

public abstract class Plant {
    private String name;
    private int price;
    private String color;

    public Plant(String name, int price, String color) {
        this.name = name;
        this.price = price;
        this.color = color;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public abstract int getLength();
    public abstract Integer getFreshness();
}
