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

    private final List<String> VALID_JOBS = List.of("Google", "Uber", "Amazon");
    private final List<String> VALID_ADDRESSES = List.of("London", "New York", "Amsterdam");
    private final int VALID_AGE = 18;

    public User(String name, int age, String workPlace, String address) {

        if(name.isBlank())
            throw new IllegalArgumentException("Имя пользователя не может быть пустым!");

        if(VALID_AGE > age)
            throw new IllegalArgumentException("Возраст пользователя должен быть больше " + VALID_AGE);

        if(!VALID_JOBS.contains(workPlace))
            throw new IllegalArgumentException("Пользователя должен работать в одной из компаний : " + VALID_JOBS);

        if(!VALID_ADDRESSES.contains(address))
            throw new IllegalArgumentException("Пользователь должен проживать в одном из городов : " + VALID_ADDRESSES);

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