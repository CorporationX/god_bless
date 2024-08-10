package faang.school.godbless;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class Application {
    public static void main(String[] args) {

        User userBob = new User("Bob", 32, "Analyst", "Cypress str.");
        User userTom = new User("Tom", 25, "Analyst", "Cypress str.");
        User userMary = new User("Mary", 25, "Analyst", "Cypress str.");
        User userJane = new User("Jane", 32, "Analyst", "Cypress str.");
        User userPeter = new User("Peter", 17, "Analyst", "Cypress str.");

        List<User> list = new ArrayList<>();
        List<User> emptyList = new ArrayList<>();
        list.add(userBob);
        list.add(userTom);
        list.add(userMary);
        list.add(userJane);
        list.add(userPeter);

        try {
            Map<Integer, List<User>> result = User.groupUsers(list);
            System.out.println(result.toString());

        } catch (Exception e) {
            System.out.println("List of users is empty");

        }


    }
}