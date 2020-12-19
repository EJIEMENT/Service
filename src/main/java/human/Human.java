package human;


import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement(name = "human")
@XmlType(propOrder = {"name", "surname", "age", "address"})
public class Human {
    public int id;
    public String name;
    public String surname;
    public Address address;
    public int age;

    public Human(int id,String name, String surname, int age, Address address) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.age = age;
    }

    public Human() {
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Human{" +
                "id='" + id + '\'' +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", address=" + address +
                ", age=" + age +
                "}\n";
    }


}






