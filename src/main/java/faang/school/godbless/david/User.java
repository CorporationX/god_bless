package faang.school.godbless.david;

import lombok.Getter;
import java.util.*;

@Getter
public class User {
    private String name;
    private int age;
    private String workplace;
    private String address;

    public static Set<String> VALID_JOBS = Set.of("Google","Uber","Amazon");
    public static Set<String> VALID_ADDRESSES = Set.of("London","New York","Amsterdam");

    public User(String name, int age, String workplace, String address) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
        if (age < 18) {
            throw new IllegalArgumentException("Возраст не может быть меньше 18");
        }
        if (!VALID_JOBS.contains(workplace)) {
            throw new IllegalArgumentException("Место работы должно быть одним из допустимых:" + VALID_JOBS);
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Адрес должен быть одним из допустимых:" + VALID_ADDRESSES);
        }

        this.name = name;
        this.age = age;
        this.workplace = workplace;
        this.address = address;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> userGroups = new HashMap<>();
        for (User user : users) {
            int age = user.getAge();
            if(!userGroups.containsKey(age)) {
                userGroups.put(age, new ArrayList<>());
            }
            userGroups.get(age).add(user);
        }
        return userGroups;
    }

    @Override
    public String toString() {
        return "User{name='" + name + "', age=" + age + ", workplace='" + workplace + "', address='" + address + "'}";
    }
}
