package school.faang.bjs_85538;

import java.util.List;

public class Runner {
    public static void main(String[] args) {
        List<User> users = List.of(
                new User("Nikolay", 18, "Uber", "New York"),
                new User("Marsel", 23, "Google", "Amsterdam"));

        System.out.println(users);
    }
}
