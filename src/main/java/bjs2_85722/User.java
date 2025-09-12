package bjs2_85722;

import java.util.*;

class User {
    // Поля
    private String name;
    private int age;
    private String workplace;
    private String address;

    // Конструктор
    public User(String name, int age, String workplace, String address) {
        this.name = name;
        this.age = age;
        this.workplace = workplace;
        this.address = address;
    }

    // Геттеры
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getWorkplace() { return workplace; }
    public String getAddress() { return address; }

    // Метод группировки
    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> grouped = new HashMap<>();

        for (User user : users) {
            grouped.putIfAbsent(user.getAge(), new ArrayList<>());
            grouped.get(user.getAge()).add(user);
        }

        return grouped;
    }

}