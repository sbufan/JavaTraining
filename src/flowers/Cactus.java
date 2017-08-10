package flowers;

public class Cactus extends Plant {
    private String form;

    public Cactus(String name, int price, String color, String form) {
        super(name, price, color);
        this.form = form;
    }

    public String getForm() {
        return form;
    }

    @Override
    public int getLength() {
        return 0;
    }

    @Override
    public Integer getFreshness() {
        return null;
    }
}
