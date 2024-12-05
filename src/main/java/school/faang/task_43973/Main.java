package school.faang.task_43973;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>(); 

        users.add(new User("Stasik", 28, "Google", "Moscow"));
        users.add(new User("Vasya", 30, "Kebab Turkish", "Saint Petersburg"));
        users.add(new User("Veronika", 25, "Logitech", "US Texas"));
        users.add(new User("Ivan", 25, "ASUS", "Monaco"));
        users.add(new User("Bobik", 27, "Apple", "Silicon Valley"));

        Map<Integer, List<User>> groupedUsers = User.groupUsers(users);
        
        groupedUsers.forEach((age, userList) -> {
            System.out.println("\n-------------------------\n" 
                + "Age - " + age + "\n\n");
            userList.forEach(user -> 
                System.out.println("Address: " + user.getAddress() 
                    + "\n Age: " + user.getAge() 
                    + "\n Name: " + user.getName() 
                    + "\n Workplace: " + user.getWorkplace()));
        });
        
    }
}
