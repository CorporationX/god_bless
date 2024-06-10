package user.registration;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class Main  {
    public static void main(String[] args) {

        List<User> users = new ArrayList<>();
        users.add(new User("Vlad", 27, "Uber", "Amsterdam"));
        users.add(new User("Ivan", 29, "Google", "New York"));
        users.add(new User("Andrey", 32, "Amazon", "London"));

        Map<Integer, List<User>> usersByAge = User.groupUser(users);

        for (Map.Entry<Integer, List<User>> entry : usersByAge.entrySet()) {
            System.out.println("Age: " + entry.getKey());
            for (User user : entry.getValue()) {
                System.out.println("Name: " + user.getName() + ", Work place: " + user.getWorkPlace() + ", Address: " + user.getAddress());
            }
        }
    }
}