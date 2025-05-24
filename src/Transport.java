public class Transport {
    private String name;
    private int price;

    public String getName() {
        return name;
    }

    public Transport setName(String name) {
        this.name = name;
        return this;
    }

    public int getPrice() {
        return price;
    }

    public Transport setPrice(int price) {
        this.price = price;
        return this;
    }

    public String fuel() {
        return " заправляется бензином";
    }

    @Override
    public String toString() {
        return name;
    }
}
