package school.faang.bjs2_31388;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<User> userList = new ArrayList<>();

        // Заполняем список 10 пользователями
        userList.add(new User("Alice Johnson", 34, "TechCorp", "123 Main St, New York"));
        userList.add(new User("Bob Smith", 34, "Innovate Ltd.", "456 Oak St, Los Angeles"));
        userList.add(new User("Charlie Williams", 29, "DevSolutions", "789 Pine St, Chicago"));
        userList.add(new User("Diana Brown", 31, "WebStudio", "101 Maple St, Houston"));
        userList.add(new User("Eve Miller", 29, "AI Enterprises", "202 Cedar St, Phoenix"));
        userList.add(new User("Frank Davis", 40, "CloudNet", "303 Birch St, San Francisco"));
        userList.add(new User("Grace Wilson", 27, "DataInsights", "404 Spruce St, Seattle"));
        userList.add(new User("Henry Anderson", 33, "CyberTech", "505 Ash St, Miami"));
        userList.add(new User("Isabella Martinez", 30, "DesignPro", "606 Elm St, Boston"));
        userList.add(new User("Jack Thomas", 34, "FinServices", "707 Willow St, Denver"));

        Map<Integer, List<User>> groupedUsers =  User.groupUser(userList);

        System.out.println(groupedUsers);
    }
}
