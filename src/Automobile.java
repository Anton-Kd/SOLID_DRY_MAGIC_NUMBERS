public class Automobile extends Transport {
    private final String name = "Автомобиль";

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int getPrice() {
        return 200;
    }
}
