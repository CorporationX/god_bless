package BJS2_18476;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {

        List<User> userList = new ArrayList<>();

        userList.add(new User("Sergey", 22, "Google", "London"));
        userList.add(new User("Andrew", 25, "Uber", "New York"));
        userList.add(new User("Misha", 25, "Google", "London"));
        userList.add(new User("Vera", 22, "Uber", "New York"));
        userList.add(new User("Masha", 30, "Amazon", "Amsterdam"));
        userList.add(new User("Vlad", 30, "Amazon", "Amsterdam"));

        System.out.println(User.groupUsers(userList));
    }
}
