package flowers;

public class Flower extends Plant {
    private int length;
    private int freshness;

    public Flower(String name, int price, String color, int length, int freshness) {
        super(name, price, color);
        this.length = length;
        this.freshness = freshness;
    }

    @Override
    public int getLength() {
        return length;
    }

    @Override
    public Integer getFreshness() {
        return freshness;
    }
}
