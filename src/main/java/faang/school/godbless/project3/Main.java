package faang.school.godbless.project3;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("Alisa", 25, "Amazon", "Amsterdam"));
        users.add(new User("Denis", 31, "T-Bank", "street2"));
        users.add(new User("Demid", 25, "WB", "street3"));

        var result = User.groupedUsers(users);
        result.entrySet().forEach(System.out::println);


    }
}
