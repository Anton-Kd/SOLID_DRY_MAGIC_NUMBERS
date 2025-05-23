import java.util.Map;

// Single-responsibility principle каждый класс
// выполняет функции для которых создан.
//Open Closed Principle добаляя интерфес у класса появилась
//новая функциональость
public class Product implements InfoProduct {
    protected String productName;
    protected String company;
    protected int productPrice;

    public Product(String productName, String company, int productPrice) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.company = company;

    }

    public Product(String productName, int productPrice) {
        this.productName = productName;
        this.productPrice = productPrice;
    }


    public String getProductName() {
        return productName;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public String getCompany() {
        if (company.isEmpty()) {
            return "Изготовитель не указан";
        }
        return company;
    }


    @Override
    public String toString() {
        return productName + "-" +
                productPrice + " руб/шт\n";
    }

    @Override
    public void sellBy() {
        if (!getCompany().isEmpty() && getCompany().equals("OOO Молзавод")) {
            System.out.println(productName + "годен до 30.05.23");
        }
        System.out.println(productName + "годен до 24.05.25");
    }
}


