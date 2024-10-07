package tasks.bjs2_31732;

import tasks.User;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        addUsers(users);
        System.out.println("Пользователи прошедшие валидацию");
        User.showUsers(users);
    }

    public static void addUsers(List<User> users) {
        System.out.println("Добавляем пользователей в список с учетом валидации данных...");
        addUser(users, "", 30, "Яндекс", "London");
        addUser(users, "Дмитрий", 17, "Google", "London");
        addUser(users, "Мария", 30, "СБП", "г. Санкт-Петербург, Невский пр., д. 25");
        addUser(users, "Екатерина", 22, "Google", "г. Новосибирск, ул. Ленина, д. 5");
        addUser(users, "Иван", 32, "Google", "Amsterdam");
        addUser(users, " ", 30, "Google", "Amsterdam");
        addUser(users, "Сергей", 19, "Uber", "New York");
        addUser(users, "Анна", 55, "Билайн", "New York");
        addUser(users, "Николай", 20, "Amazon", "г. Челябинск, проспект Победы, д. 4");
        addUser(users, "Вера", 32, "Amazon", "London");
    }

    public static void addUser(List<User> users, String name, int age, String workPlace, String address) {
        System.out.println("Добавление пользователя : '" + name + "'");
        try {
            users.add(new User(name, age, workPlace, address));
            System.out.println("Успешно добавлен");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
