package UserRegistration;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        User olya = new User("olya", 24, "Uber", "London");
        User kolya = new User("kolya", 21, "Uber", "London");
        User molya = new User("molya", 21, "Uber", "London");
        User tolya = new User("tolya", 24, "Uber", "London");

        List<User> users = Arrays.asList(olya, kolya, tolya, molya);
        users.forEach(s -> System.out.print(s + " "));
    }
}
