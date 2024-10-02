package dima.evseenko.group;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println(User.groupUsers(getUsers()));
    }

    private static List<User> getUsers(){
        return Arrays.asList(
                new User("Dima", 22, "Amazon", "New York"),
                new User("Kolya", 20, "Google", "New York"),
                new User("Olya", 22, "Google", "Amsterdam"),
                new User("Vasya", 21, "Amazon", "New York"),
                new User("Vladislav", 19, "Uber", "London"),
                new User("Polina", 23, "Google", "Amsterdam"),
                new User("Igor", 20, "Amazon", "London")
        );
    }
}
