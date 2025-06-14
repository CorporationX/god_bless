package school.faang.bjs2_79312;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    public static final String TEXT_AGE = "Age: ";
    private String name;
    @Getter
    private int age;
    private String workplace;
    private String address;

    public User(String name, int age, String workplace, String address) {
        this.name = name;
        this.age = age;
        this.workplace = workplace;
        this.address = address;
    }

    @Override
    public String toString() {
        return " >>> User | " +
                "name = " + name +
                ", age = " + age +
                ", workplace = " + workplace +
                ", address = " + address;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> groupedMap = new HashMap<>();

        for (User user : users) {
            int currentAge = user.getAge();

            if (!groupedMap.containsKey(currentAge)) {
                groupedMap.put(currentAge, new ArrayList<>());
            }

            groupedMap.get(currentAge).add(user);
        }

        return groupedMap;
    }
}

