package dima.evseenko.group;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println(User.groupUsers(getUsers()));
    }

    private static List<User> getUsers(){
        return Arrays.asList(
                new User("Dima", 22, "Amazon", "Poland"),
                new User("Kolya", 20, "Randstad", "Poland"),
                new User("Olya", 22, "Google", "England"),
                new User("Vasya", 21, "DNS", "Russia"),
                new User("Vladislav", 19, "Uber", "Amsterdam"),
                new User("Polina", 23, "Amazon", "Poland"),
                new User("Igor", 20, "Amazon", "Poland")
        );
    }
}
