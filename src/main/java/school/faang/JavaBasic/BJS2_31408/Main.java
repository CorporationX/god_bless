package school.faang.JavaBasic.BJS2_31408;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>(List.of(
                new User("Alice", 27, "TechCorp", "123 Main St"),
                new User("Bob", 34, "HealthInc", "456 Elm St"),
                new User("Charlie", 25, "FinanceCo", "789 Oak St"),
                new User("Diana", 30, "EduSolutions", "321 Pine St"),
                new User("Edward", 40, "RetailHub", "654 Cedar St"),
                new User("Fiona", 22, "StartupX", "987 Maple St"),
                new User("George", 22, "MediaGroup", "135 Birch St"),
                new User("Hannah", 31, "EcoFriendly", "246 Spruce St"),
                new User("Ian", 27, "ConsultingFirm", "369 Willow St")
        ));
        Map<Integer, List<User>> groupedUsersByAge = User.groupUsers(users); // Вызов через класс User
        for (Map.Entry<Integer, List<User>> entry : groupedUsersByAge.entrySet()) {
            System.out.println("Age: " + entry.getKey());
            List<User> usersByAge = entry.getValue();
            for (User user : usersByAge) {
                System.out.println(user);
            }
        }
    }
}
