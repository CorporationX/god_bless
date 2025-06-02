package school.faang.groupingUsersByAge;

import java.util.ArrayList;
import java.util.List;

public class GrupingUsersBayAgeTest {

    public static void main(String[] args) {

        List<User> userList = new ArrayList<>();
        userList.add(new User("Vlad", 22, "Moskov", "Omsk"));
        userList.add(new User("Max", 22, "Moskov", "Vladivostok"));
        userList.add(new User("Dani", 18, "Moskov", "Moskov"));
        userList.add(new User("Jon", 22, "Vladivostok", "Omsk"));
        userList.add(new User("Bob", 22, "Tula", "Omsk"));
        userList.add(new User("Lim", 20, "Tula", "Omsk"));
        userList.add(new User("Tom", 18, "Omsk", "Omsk"));

        System.out.println(User.groupUsers(userList).get(22));
    }
}
