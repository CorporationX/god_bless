package faang.school.godbless.BJS2_4125;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> users = Arrays.asList(
                new User("Andrei", (byte) 22, "Stick", "Jersey City"),
                new User("Victor", (byte) 20, "Lyft", "New York"),
                new User("Vlad", (byte) 21, "Amazon", "Los Angeles"),
                new User("Jack", (byte) 21, "Uber", "Boston"),
                new User("Nick", (byte) 23, "Google", "Miami")
        );

        System.out.println(User.groupUsersByAge(users));
    }
}
