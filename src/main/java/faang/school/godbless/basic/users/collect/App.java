package faang.school.godbless.basic.users.collect;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class App {
    public static void main(String[] args) {

        String bike = "Bike";
        String snowboard = "Snowboard";
        String ski = "Ski";
        String swimming = "Swimming";
        String tennis = "Tennis";

        Set<String> hobbies = new HashSet<>();
        hobbies.add(bike);
        hobbies.add(snowboard);
        hobbies.add(ski);
        hobbies.add(swimming);

        Set<String> johnHobbies = new HashSet<>();
        johnHobbies.add(bike);
        johnHobbies.add(snowboard);

        Set<String> danHobbies = new HashSet<>();
        danHobbies.add(ski);
        danHobbies.add(swimming);

        Set<String> alexHobbies = new HashSet<>();
        alexHobbies.add(tennis);
        alexHobbies.add(swimming);

        User user1 = new User(1, "John", 30, johnHobbies);
        User user2 = new User(2, "Dan", 25, danHobbies);
        User user3 = new User(3, "Alex", 35, alexHobbies);
        User user4 = new User(4, "Konstantin", 35, alexHobbies);

        ArrayList<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);

        // Result Collect users
        HashMap<Integer, String> result = new HashMap<>();
        for (User user: users) {
            HashMap<Integer, String> userHobbyLovers = user.findHobbyLovers(user, hobbies);
            System.out.println("Founded hobby for " + user.getName() + " is: " + userHobbyLovers);
            result.putAll(userHobbyLovers);
        }
        System.out.println("Result: " + result);


        // Resul Group users by age
        HashMap<Integer, ArrayList<User>> groupUsersByAge = User.groupUsers(users);
        System.out.println("Grouped users by age: " + groupUsersByAge);

        // Register user
        try {
            User user5 = new User(5, "", 16, "Google", "Amsterdam" );
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            User user5 = new User(5, "John", 16, "Google", "Amsterdam" );
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            User user6 = new User(6, "Dan", 25, "Uber", "Amsterdam");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            User user7 = new User(7, "Alex", 35, "Yandex", "Amsterdam");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            User user8 = new User(8, "Konstantin", 35, "Google", "Moscow");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            User user9 = new User(9, "Rex", 35, "Google", "New York");
            System.out.println("User " + user9 + " matches all requirements ");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }






    }
}
