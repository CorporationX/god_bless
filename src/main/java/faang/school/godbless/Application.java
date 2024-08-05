package faang.school.godbless;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.HashMap;

public class Application {
    public static void main(String[] args) {

        User user = new User("Bob", 32, "Analyst", "Cypress str.");
        User user1 = new User("Tom", 25, "Analyst", "Cypress str.");
        User user2 = new User("Mary", 25, "Analyst", "Cypress str.");
        User user3 = new User("Jane", 32, "Analyst", "Cypress str.");
        User user4 = new User("Peter", 17, "Analyst", "Cypress str.");

        ArrayList<User> list = new ArrayList<>();
        ArrayList<User> emptyList = new ArrayList<>();
        list.add(user);
        list.add(user1);
        list.add(user2);
        list.add(user3);
        list.add(user4);

        try {
            HashMap<Integer, List<User>> result = User.groupUsers(list);
            HashMap<Integer, List<User>> badResult = User.groupUsers(emptyList);
            System.out.println(result.toString());

        } catch (Exception e) {
            System.out.println("List of users is empty");

        }


    }
}