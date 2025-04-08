package userAgeGrouping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> usersList = new ArrayList<>(Arrays.asList(
                new User("Frodo", 18,"Shire", "Shire street 12"),
                new User("Gimli", 120, "Underway", "Ered Luin"),
                new User("Aragorn", 70, "Gondor", "Gondor"),
                new User("Sam", 18, "Shire", "Shire street 15"),
                new User("Gandalf", 99, "everywhere", "on Earth")
        ));

        System.out.println(User.groupUsers(usersList));
    }
}
