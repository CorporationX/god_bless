package faang.school.godbless.task_work_users;

import faang.school.godbless.task_work_users.users.User;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final List<User> users = new ArrayList<>();

    public static void main(String[] args) {

        checkUserValid("pavel", 23, "Google", "London");
        checkUserValid("ivan", 23, "Uber", "Amsterdam");
        checkUserValid("pavel", 21, "Amazon", "New York");
        checkUserValid("dima", 21, "Google", "London");
        checkUserValid("petr", 21, "Uber", "Amsterdam");
        checkUserValid("pavel", 32, "Amazon", "New York");
        checkUserValid("leha", 32, "Google", "London");
        checkUserValid("rinat", 32, "Uber", "Amsterdam");
        checkUserValid("anton", 23, "Amazon", "New York");

        
        User.getGroupUserAge(users).forEach((key, value) -> {
            System.out.println(key);
            value.forEach(n -> System.out.println(n.toString()));
        });
    }

    private static void checkUserValid(String name, int age, String company, String city) {
        try {
            users.add(new User(name, age, company, city));
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }
}
