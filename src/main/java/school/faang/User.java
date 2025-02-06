package school.faang;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

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
            throw new IllegalArgumentException("Incorrect data entered"); //Введены неверные данные
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
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age && Objects.equals(name, user.name) && Objects.equals(workplace, user.workplace) && Objects.equals(address, user.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, workplace, address);
    }

    @Override
    public String toString() {
        return "User: " +
                "name - " + name +
                ", age - " + age +
                ", workplace - " + workplace +
                ", address - " + address;
    }

    public static Map<Integer, List<User>> groupUsers (List<User> users) {
        Map<Integer, List<User>> usersMap = users.stream()
                .collect(Collectors.groupingBy(User::getAge));
        return usersMap;
    }
}
