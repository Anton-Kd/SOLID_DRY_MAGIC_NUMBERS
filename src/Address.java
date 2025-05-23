import java.util.UUID;

public class Address {
    private String city;
    private String street;
    private String apartment;

    public Address(String city, String street, String apartment) {
        this.city = city;
        this.street = street;
        this.apartment = apartment;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getApartment() {
        return apartment;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }

    @Override
    public String toString() {
        return "Город - " + city + "\n"
                + "Улица - " + street + "\n"
                + "Квартира - " + apartment + "\n";

    }
}