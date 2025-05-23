import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Shop {
    // корректировка на единичку (магическое число) и использование констант.
    static final int ONE = 1;
    static final AtomicInteger sumProducts = new AtomicInteger();
    static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        Map<Product, Integer> basket = new HashMap<>();
        List<Product> dairyDepartment = new ArrayList<>();
        List<Product> bakeryDepartment = new ArrayList<>();
        List<Product> groceryDepartment = new ArrayList<>();

        Product product1 = new Product("Молоко 2,5%", "ООО Молзавод", 90);
        Product product2 = new Product("Молоко 3,5%", "ООО Молзавод", 100);
        Product product3 = new Product("Кефир 2,5%", "ООО Искра", 110);
        Product product4 = new Product("Кефир 3,5%", "ООО Искра", 120);
        dairyDepartment.add(product1);
        dairyDepartment.add(product2);
        dairyDepartment.add(product3);
        dairyDepartment.add(product4);

        Product product5 = new Product("Хлeб", "ООО Хлебзавод", 50);
        Product product6 = new Product("Лаваш", "ИП Рахимов", 50);
        Product product7 = new Product("Калач", "OOO Мукомол", 50);
        bakeryDepartment.add(product5);
        bakeryDepartment.add(product6);
        bakeryDepartment.add(product7);

        Product product8 = new Product("Конфеты", "ООО Сладкоежка", 140);
        Product product9 = new Product("Шоколад", "ООО Красный сентябрь", 180);
        Product product10 = new Product("Вафли", 200);
        groceryDepartment.add(product8);
        groceryDepartment.add(product9);
        groceryDepartment.add(product10);

        Departments department1 = new Departments("Молочный отдел", dairyDepartment);
        Departments department2 = new Departments("Хлебобулочный отдел", bakeryDepartment);
        Departments department3 = new Departments("Бакалейный отдел", groceryDepartment);

        Departments[] departments = {department1, department2, department3};
        int nameProduct;
        int quantity;

        System.out.println("Доставка до двери, ознакомтесь с услугами. ");
        while (true) {
            System.out.println("Доступные отделы:");
            for (int i = 0; i < departments.length; i++) { // здесь лучше обратиться к размеру отделов а не к цифре.
                System.out.println(i + ONE + ". " + departments[i]);
            }
            System.out.print("\nВыберите номер отдела: ");
            String end = scanner.nextLine();
            if (end.equals("end") || end.equals("0")) {
                System.out.printf("""
                        Покупка завершена
                        Ожидайте товары на сумму %s руб:
                        """, sumProducts);
                basket.forEach((x, y) -> System.out.println(x.getProductName()
                        + " - "
                        + y.toString() + " шт"));
                if (basket.isEmpty()) {
                    break;
                }
                System.out.print("Введите город: ");
                String city = scanner.nextLine();
                System.out.print("Введите название улицы: ");
                String street = scanner.nextLine();
                System.out.print("Введите номер дома: ");
                String apartment = scanner.nextLine();
                Customer customer = new Customer("Заказ", new Address(city, street, apartment));
                System.out.printf("Ваш %s придет по адресу: %n%s под номером %s",
                        customer.getName(),
                        customer.getAddress().toString(),
                        customer.getCustomerUUID());
                break;
            }

            int numberDepartment = Integer.parseInt(end);
            switch (numberDepartment) {
                case 1: {
                    Departments.showList(department1); // Не повторяться, а вызвать метод. Принцип DRY
                    break;
                }
                case 2: {
                    Departments.showList(department2);
                    break;
                }
                case 3: {
                    Departments.showList(department3);
                    break;
                }
                default:
                    System.out.println("Такого номера нет");
                    continue;
            }

            System.out.print("Введите номер товара\n" +
                    "или завершите покупку введите <0>: ");
            String number = scanner.nextLine();
            nameProduct = Integer.parseInt(number);
            if (nameProduct == 0) {
                System.out.println("Покупка завершена");
                continue;
            }
            System.out.print("Выберите количество: ");
            String number1 = scanner.nextLine();
            quantity = Integer.parseInt(number1);
            if (nameProduct - ONE > departments[numberDepartment - ONE].getGoods().size() - ONE) {
                System.out.println("Вы указали неверное число.");
                continue;
            }
            basket.put(departments[numberDepartment - ONE].getGoods().get(nameProduct - ONE), quantity);
            basket.forEach((x, y) -> {
                        sumProducts.addAndGet(x.productPrice * y);
                    }
            );
            System.out.printf("\nУ вас в корзине товара на сумму %s руб.\n", sumProducts);
            basket.forEach((x, y) -> System.out.println(x.getProductName()
                    + " - "
                    + y.toString() + " шт"));
        }
    }
}






