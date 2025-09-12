package school.faang.bjs2_85722;

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

public class Main {
    public static void main(String[] args) {
        // Создаем список пользователей
        List<User> users = new ArrayList<>();
        users.add(new User("Билл", 25, "Google", "Новосиб"));
        users.add(new User("Чак", 30, "Amazon", "Томск"));
        users.add(new User("Сергей", 25, "Yandex", "Джамбул"));
        users.add(new User("Сингх", 30, "Microsoft", "Алматы"));
        users.add(new User("Мугамба", 40, "Tesla", "Из дому"));

        // Группировка
        Map<Integer, List<User>> grouped = User.groupUsers(users);

        // Вывод результата
        for (Map.Entry<Integer, List<User>> entry : grouped.entrySet()) {
            System.out.println("Возраст " + entry.getKey() + ":");
            for (User u : entry.getValue()) {
                System.out.println("  " + u.getName() + " (" + u.getWorkplace() + ", " + u.getAddress() + ")");
            }
        }
    }
}