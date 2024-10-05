package tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class User {
    private String name;
    private int age;
    private String workPlace;
    private String address;

    public User(String name, int age, String workPlace, String address) {
        this.name = name;
        this.age = age;
        this.workPlace = workPlace;
        this.address = address;
    }

    public String getInformation() {
        return String.format("Я %s. Мой возраст : %d. Мой адрес : %s. Работаю в : %s", name, age, address, workPlace);
    }

    public static void showUsers(List<User> users) {
        for (User user : users) {
            System.out.println(user.getInformation());
        }

        System.out.println();
    }

    public static void showUsersSortedByAge(Map<Integer, List<User>> users) {
        for (Integer age : users.keySet()) {
            System.out.println(String.format("Пользователи чей возраст : %d", age));
            showUsers(users.get(age));
        }

        System.out.println();
    }

    public static Map<Integer, List<User>> groupUser(List<User> users) {
        Map<Integer, List<User>> groupedUsersByAge = new TreeMap<>();

        for (User user : users) {
            groupedUsersByAge.putIfAbsent(user.age, new ArrayList<>());
            groupedUsersByAge.get(user.age).add(user);
        }

        return groupedUsersByAge;
    }
}