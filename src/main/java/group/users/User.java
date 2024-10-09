package group.users;

import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class User {
    public static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    public static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private String name;
    private int age;
    private String workplace;
    private String address;

    public User(String name, int age, String workplace, String address) throws IllegalAccessException {
        if (name != null) {
            this.name = name;
        } else {
            throw new IllegalAccessException("имя не может быть пустым");
        }
        if (age >= 18) {
            this.age = age;
        } else {
            throw new IllegalAccessException("возраст не может быть меньше 18");
        }
        if (VALID_JOBS.contains(workplace)) {
            this.workplace = workplace;
        } else {
            throw new IllegalAccessException("место работы должно содержаться во множестве VALID_JOBS");
        }
        if (VALID_ADDRESSES.contains(address)) {
            this.address = address;
        } else {
            throw new IllegalAccessException("адрес должен содержаться во множестве");
        }
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> groupedUsers = new HashMap<>();
        for (User user : users) {
            groupedUsers.putIfAbsent(user.getAge(), new ArrayList<>());
            groupedUsers.get(user.getAge()).add(user);
        }
        return groupedUsers;
    }

    public static void printResult(Map<Integer, List<User>> map) {
        for (Map.Entry<Integer, List<User>> entry : map.entrySet()) {
            for (User user : entry.getValue()) {
                System.out.println("Возраст: " + entry.getKey() + " лет" + "\n" + "Имя: " + user.getName() + "\n");
            }
        }
    }
}