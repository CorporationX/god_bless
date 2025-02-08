package school.faang.BJS2_56414;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        User firstUser = new User("Vladimir", 25, "Google", "Amsterdam");
        User secondUser = new User("Elena", 32, "Ozon", "Moscow");
        User thirdUser = new User("Sergei", 32, "Uber", "New York");
        User fourthUser = new User("Veronika", 27, "Spotify", "Seoul");

        List<User> allUsers = List.of(firstUser, secondUser, thirdUser, fourthUser);
        Map<Integer, List<User>> usersByAge = User.groupUsers(allUsers);
        System.out.println(usersByAge);
    }
}
