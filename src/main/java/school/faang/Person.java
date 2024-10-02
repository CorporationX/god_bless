package school.faang;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Person {
    private String name;
    private int age;
    private String workplace;
    private String address;

    public Person(String name, int age, String workplace, String address) {
        this.name = name;
        this.age = age;
        this.workplace = workplace;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getWorkplace() {
        return workplace;
    }

    public String getAddress() {
        return address;
    }

    public static Map<Integer, List<Person>> groupPersonByAge(List<Person> persons) {
        Map<Integer, List<Person>> groupedPersons = new HashMap<>();

        for (Person person : persons) {
            groupedPersons.putIfAbsent(person.getAge(), new ArrayList<>());
            groupedPersons.get(person.getAge()).add(person);
        }
        return groupedPersons;

    }

    public static List<Person> getPersons() {
        return List.of(
                new Person("Denis", 17, "Google", "New York"),
                new Person("Ivan", 17, "Amazon", "Boston"),
                new Person("Sergey", 17, "Facebook", "Hong-Kong"),
                new Person("Galina", 41, "Alibaba", "Khabarovsk"),
                new Person("Tatyana", 53, "IBM", "Irkutsk"),
                new Person("Agnia", 65, "RosAviacia", "Moscow"),
                new Person("Artem", 65, "Rosnano", "St. Petersburg")
        );
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + ", workplace='" + workplace + "', address='" + address + "'}";
    }
 }
