import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Main {

    private static final List<User> USERS = new ArrayList<>();
    private static final Map<Integer, List<User>> GROUP_USERS = new HashMap<>();

    public static void main(String[] args) {

        USERS.add(new User("Egor", 18, "it", "Spb"));
        USERS.add(new User("Masha", 23, "it", "Msk"));
        USERS.add(new User("Pasha", 24, "it", "Ekb"));
        USERS.add(new User("Sasha", 23, "it", "Oms"));
        groupUsers();
        printAllGroupedUsers();
    }

    private static void groupUsers() {
        for (User user : USERS) {
            int key = user.getAge();
            GROUP_USERS.computeIfAbsent(key, k -> new ArrayList<>()).add(user);

        }
    }

    public static void printAllGroupedUsers() {
        for (Map.Entry<Integer, List<User>> entry : GROUP_USERS.entrySet()) {
            System.out.println("Age: " + entry.getKey());
            for (User user : entry.getValue()) {
                System.out.println("   " + user);
            }
        }
    }
}