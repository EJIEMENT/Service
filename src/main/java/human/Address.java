package human;

public class Address {
    public String city;
    public String street;
    public int booth;

    public Address(String city, String street, int booth) {
        this.city = city;
        this.street = street;
        this.booth = booth;
    }

    public Address() {
    }


    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", booth=" + booth +
                '}';
    }
}
