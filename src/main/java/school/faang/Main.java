package school.faang;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        User firstUser = new User("Vladimir", 25, "Google", "Amsterdam");
        User secondUser = new User("Elena", 32, "Ozon", "Moscow");
        User thirdUser = new User("Sergei", 32, "Uber", "New York");
        User foursUser = new User("Veronika", 27, "Spotify", "Seoul");

        List<User> allUsers = Arrays.asList(firstUser, secondUser, thirdUser, foursUser);
        Map<Integer, List<User>> groupUsers = User.groupUsers(allUsers);
        System.out.println(groupUsers);
    }
}
