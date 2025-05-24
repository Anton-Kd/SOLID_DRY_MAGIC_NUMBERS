import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
//Open Closed Principle добаляя интерфес у класа появилась
//новая функциональость.

public class Departments implements Manufacturer, InfoProduct {
    protected String name;
    List<Product> goods;

    public Departments(String name, List<Product> goods) {
        this.name = name;
        this.goods = goods;
    }

    public String getName() {
        return name;
    }

    public List<Product> getGoods() {
        return goods;
    }

    @Override
    public String toString() {
        return name;
    }
    // Создадим метод для вывода списка на экран пользователя.
    // Повторяющаяся логика, мы просто обратимся  к этому методу.

    static void showList(Departments department) {
        System.out.println("Вы выбрали " + "<" + department.getName() + ">" + "\n"
                + "вот список доступных товаров:");
        AtomicInteger productList = new AtomicInteger(1);
        department.getGoods().forEach(x -> System.out.println(productList.getAndIncrement() + ". "
                + x.getProductName() + " "
                + x.getProductPrice() + " руб/кг"));
    }

    @Override
    public void manufacturer() {
        if (getName().equals("Молочный отдел") || getName().equals("Хлебобулочный отдел")) {
            System.out.println("Страна Россия");
        } else {
            System.out.println("Страна Бельгия");
        }
    }

    @Override
    public void sellBy() {
        if (getName().equals("Молочный отдел") || getName().equals("Хлебобулочный отдел")) {
            System.out.println("Продать за неделю");
        } else {
            System.out.println("Продать до 30.08.25");
        }
    }
}