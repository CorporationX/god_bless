package school.faang;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        List<User> users = getUsers();

        Map<Integer, List<User>> usersByAge = User.groupUsers(users);
        System.out.println("Users by age:" + usersByAge);
    }

    private static List<User> getUsers() {
        List<User> users = new ArrayList<>();
        users.add(new User("Agnetha", 20, "first floor", "main office"));
        users.add(new User("Bob", 25, "second floor", "north branch"));
        users.add(new User("Tom", 25, "basement", "main office"));
        users.add(new User("Roman", 24, "first floor", "main office"));
        users.add(new User("Anni", 23, "basement", "north branch"));
        users.add(new User("Bill", 20, "second floor", "north branch"));
        return users;
    }
}
