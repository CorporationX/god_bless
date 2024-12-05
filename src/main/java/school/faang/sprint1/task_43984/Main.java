package school.faang.sprint1.task_43984;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ArrayList<User> users = new ArrayList<>(
                Arrays.asList(new User(
                        25,
                        "rauan",
                        "kz",
                        "remote"
                ), new User(
                        39,
                        "John",
                        "us",
                        "office"
                ), new User(
                        23,
                        "Dimash",
                        "kz",
                        "office"
                ), new User(
                        25,
                        "Sam",
                        "uk",
                        "remote"
                ))
        );
        System.out.printf(
                "result %s",
                User.groupUsers(users)
        );
    }
}
