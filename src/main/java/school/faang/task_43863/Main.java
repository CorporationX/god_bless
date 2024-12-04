package school.faang.task_43863;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {


    public static void main(String[] args) {

        List<User> users = new ArrayList<>();

        users.add(new User("Alice", 25, "Company A", "123 Main St"));
        users.add(new User("Bob", 30, "Company B", "456 Oak St"));
        users.add(new User("Charlie", 25, "Company C", "789 Pine St"));
        users.add(new User("David", 35, "Company A", "321 Elm St"));
        users.add(new User("Eva", 30, "Company B", "654 Maple St"));
        users.add(new User("Frank", 25, "Company D", "101 Cedar St"));
        users.add(new User("Grace", 40, "Company A", "202 Birch St"));
        users.add(new User("Hank", 30, "Company C", "303 Redwood St"));
        users.add(new User("Ivy", 25, "Company D", "404 Spruce St"));
        users.add(new User("Jack", 35, "Company B", "505 Willow St"));

        User.groupUsers(users);
        Map<Integer, List<User>> groupedUsers = User.groupUsers(users);

        for (Map.Entry<Integer, List<User>> entry : groupedUsers.entrySet()) {

            System.out.println("Age" + entry.getKey());

            Integer age = entry.getKey();
            List<User> ageGroup = entry.getValue();

            for (User user : ageGroup) {
                System.out.println("Name: " + user.getName()
                        + "Workplace: " + user.getWorkplace()
                        + "Address: " + user.getAddress());
            }
        }
    }
}
