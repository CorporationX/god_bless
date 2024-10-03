import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Main {
    private static List<User> userList = new ArrayList<>();

    public static void main(String[] args) {
        User Vasy = new User("Vasy", 18, "hgh", "Voronezh");
        User Kyza = new User("Kyza", 33, "II", "Piter");
        User Vlad = new User("Vlad", 16, "ggg", "Moscow");
        add(Vasy);
        add(Kyza);
        add(Vlad);

        Map<Integer, List<User>> group = User.groupUsers(userList);

        printAll(group);
    }

    private static void add(User user) {
        userList.add(user);
    }

    public static void printAll(Map<Integer, List<User>> user) {
        user.forEach((integer, users) -> {
            System.out.println(integer.toString() + " ");
            users.forEach(user1 -> System.out.println(user1.getName() + " "));
        });
    }
}

