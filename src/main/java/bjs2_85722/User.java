package bjs2_85722;

import java.util.*;

class User {
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

    // Геттеры (для вывода)
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

    // Статический метод группировки
    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> grouped = new HashMap<>();

        for (User u : users) {
            int age = u.getAge();

            // если список по этому возрасту ещё не создан — создаём
            grouped.putIfAbsent(age, new ArrayList<>());

            // добавляем пользователя в список по его возрасту
            grouped.get(age).add(u);
        }

        return grouped;
    }

    @Override
    public String toString() {
        return name + " (" + age + " лет, " + workplace + ", " + address + ")";
    }
}
