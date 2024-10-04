package UserRegistration;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<User> users = Arrays.asList(
                new User("olya", 17, "Uber", "London"),
                new User("kolya", 21, "Uber", "London"),
                new User("molya", 21, "Uber", "London"),
                new User("tolya", 24, "Uber", "London"));

        users.forEach(s -> System.out.print(s + " "));
    }
}
