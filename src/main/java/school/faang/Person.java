package school.faang;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Person {
    private String name;
    private int age;
    private String workplace;
    private String address;

    public static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    public static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    public Person(String name, int age, String workplace, String address) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Имя не должно быть пустым");
        }
        if (age < 18) {
            throw new IllegalArgumentException("Возраст должен быть больше 18");
        }
        if (!VALID_JOBS.contains(workplace)) {
            throw new IllegalArgumentException("Работа не соответствует ожидаемым значениям");
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Адрес не соответствует ожидаемым значениям");
        }

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
                new Person("Denis", 25, "Google", "New York"),
                new Person("Ivan", 30, "Amazon", "New York"),
                new Person("Sergey", 35, "Uber", "London"),
                new Person("Galina", 40, "Amazon", "Amsterdam"),
                new Person("Tatyana", 53, "Google", "New York"),
                new Person("Agnia", 65, "Uber", "London"),
                new Person("Artem", 124, "Amazon", "Amsterdam")
        );
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + ", workplace='" + workplace + "', address='" + address + "'}";
    }
}
