public class Motorbike extends Transport {
    private final String name = "Мотоцикл";

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
        return 100;
    }
}