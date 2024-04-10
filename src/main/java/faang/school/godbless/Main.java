package faang.school.godbless;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();

        users.add(new User("Aleh", 50, "epam", "Warsaw"));
        users.add(new User("Vasia", 50, "FB", "Washington"));
        users.add(new User("Vlad", 27, "Uber", "Amsterdam"));
        users.add(new User("Petia", 27, "Telegram", "Tokio"));
        users.add(new User("Fedia", 27, "WhatsApp", "Paris"));
        users.add(new User("Alice", 22, "Microsoft", "New York"));

        Map<Integer, List<User>> groupedUsers = User.groupUsers(users);

        for (Map.Entry<Integer, List<User>> entry : groupedUsers.entrySet()) {
            int age = entry.getKey();
            List<User> userList = entry.getValue();
            System.out.println("Age: " + age);
            for (User user : userList) {
                System.out.println("User: " + user.getName());
            }
            System.out.println();
        }
    }
}