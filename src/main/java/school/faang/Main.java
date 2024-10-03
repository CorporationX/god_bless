package school.faang;

import java.util.List;


public class Main {

    public static void main(String[] args) {

        List<User> usersList = null;

        // Проверим создание корректных пользователей
        System.out.println("Проверим создание корректных пользователей:");

        try {
            usersList = List.of(
                    new User("John", 28, "Google", "New York"),
                    new User("Bobby", 28, "Uber", "New York"),
                    new User("Robert", 33, "Amazon", "Amsterdam"),
                    new User("Dylan", 25, "Google", "London"),
                    new User("Pepe", 33, "Google", "London")
            );
            System.out.println("Пользователи созданы успешно.");
            System.out.println();
            System.out.println("~".repeat(30));
            System.out.println();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        // Проверим группировку пользователей
        System.out.println("Проверим группировку пользователей:");
        System.out.println(User.groupUsers(usersList));
        System.out.println();
        System.out.println("~".repeat(30));
        System.out.println();

        // Проверим создание невалидных пользователей
        System.out.println("Проверка случаев создания невалидных пользователей:");
        System.out.println();

        try {
            new User("", 18, "Google", "London");
        } catch (IllegalArgumentException e) {
            System.out.println("Проверка невалидного имени: " + e.getMessage());
        }

        try {
            new User("Daniel", 15, "Google", "London");
        } catch (IllegalArgumentException e) {
            System.out.println("Проверка невалидного возраста: " + e.getMessage());
        }

        try {
            new User("Daniel", 18, "WrongGoogle", "London");
        } catch (IllegalArgumentException e) {
            System.out.println("Проверка невалидного места работы: " + e.getMessage());
        }

        try {
            new User("Daniel", 15, "Google", "WrongLondon");
        } catch (IllegalArgumentException e) {
            System.out.println("Проверка невалидного места жительства: " + e.getMessage());
        }
    }
}