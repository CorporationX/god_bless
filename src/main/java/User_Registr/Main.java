package User_Registr;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("Alex", 18, "Uber", "London"));
        users.add(new User("Victor", 24, "Google", "London"));
        users.add(new User("Pavel", 25, "Uber", "London"));
        users.add(new User("Masha", 18, "Amazon", "Amsterdam"));
        users.add(new User("Leonid", 20, "Uber", "New York"));
        User.groupUsers(users);

        for (Map.Entry<Integer, List<User>> entry : User.groupUsers(users).entrySet()) {
            System.out.println("Возраст: " + entry.getKey());
            System.out.println("Данные: " + entry.getValue());
        }
    }
}