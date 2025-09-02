package school.faang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


//  Реализовать метод main

public class Main {
    public static void main(String[] args) {
        List<User> users = Arrays.asList(
                new User("Даша", 25, "Google", "Москва"),
                new User("Влад", 30, "Яндекс", "Спб"),
                new User("Никита", 25, "СберБанк", "Москва"),
                new User("Олег", 30, "Uber", "Калининград"),
                new User("Владимир", 29, "Т-банк", "Спб")
        );

        Map<Integer, List<User>> groupedByAge = User.groupUsers(users);

        System.out.println("Пользователи по возрасту:\n========================");
        for (Map.Entry<Integer, List<User>> entry : groupedByAge.entrySet()) {
            System.out.println("Возраст" + entry.getKey() + " лет:");

            for (User user : entry.getValue()) {
                System.out.println(" - " + user);
            }
            System.out.println();
        }

    }
    //1️⃣ Создать класс User с полями
    static class User {

        String name;
        int age;
        String workplace;
        String address;

        public User(String name, int age, String workplace, String address) {
            this.name = name;
            this.age = age;
            this.workplace = workplace;
            this.address = address;

        }

        // 2️⃣ Статический метод  groupUsers
        public static Map<Integer, List<User>> groupUsers(List<User> users) {
            Map<Integer, List<User>> result = new HashMap<>();

            for (User user : users) {
                int userAge = user.age;

                if (!result.containsKey(userAge)) {
                    result.put(userAge, new ArrayList<>());
                }
                result.get(userAge).add(user);
            }
            return result;
        }

        public String toString() {
            return name + " " + age + " " + workplace + " " + address;
        }
    }
}