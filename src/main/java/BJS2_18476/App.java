package BJS2_18476;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        List<User> userList = new ArrayList<>();
        try {
            userList.add(new User("Sergey", 19, "Google", "London"));
            userList.add(new User("Andrew", 25, "Uber", "New York"));
        } catch (IllegalArgumentException e) {
            System.out.println("Error! Some of the parameters are invalid or null!");
        }

        for (User user : userList) {
            System.out.println(user.toString());
        }
    }
}
