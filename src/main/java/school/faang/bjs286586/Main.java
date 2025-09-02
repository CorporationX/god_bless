package school.faang.bjs286586;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final List<User> users = new ArrayList<>();

    public static void main(String[] args) {
        try {
            users.add(new User("Oleg", 22, "Google", "London"));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(users);
    }
}
