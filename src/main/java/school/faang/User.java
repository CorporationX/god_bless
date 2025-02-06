package school.faang;

import java.util.Set;

public class User {
    private String name;
    private int age;
    private String workplace;
    private String address;

    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    public User(String name, int age, String workplace, String address) {
        if (name == null || name.isBlank()
                || age < 18
                || !VALID_JOBS.contains(workplace)
                || !VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Incorrect data entered"); //перевод Введены неверные данные
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

    @Override
    public String toString() {
        return "User: " +
                "name - " + name +
                ", age - " + age +
                ", workplace - " + workplace +
                ", address - " + address;
    }
}
