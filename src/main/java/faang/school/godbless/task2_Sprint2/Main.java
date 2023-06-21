package faang.school.godbless.task2_Sprint2;

import java.util.LinkedList;
import java.util.List;

import static faang.school.godbless.task2_Sprint2.User.groupUsers;

public class Main {
    static List<User> users = new LinkedList<>();

    public static void main(String[] args) {
        addUser("Alex", 20, "Google", "123");
        addUser("Bob", 22, "Uber", "123");
        addUser("Jon", 20, "Amazon", "London");
        addUser("Max", 20, "Russia", "New York");
        addUser("Al", 22, "Russia", "Amsterdam");
        System.out.println(groupUsers(users));
    }

    public static void addUser(String name, int age, String worksPlace, String address) {
        try {
            users.add(new User(name, age, worksPlace, address));
        } catch (IllegalArgumentException e) {
            System.out.printf("Не верный ввод пользователя с именем %s\n", name);
        }
    }


}