package school.faang.bjs2_79187;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        List<User> users = List.of(new User("Petja", 30, "JP_Morgan", "street"),
                new User("Vlad", 20, "Bank", "strasse"),
                new User("OLja", 25, "bau", "str2"),
                new User("dima", 30, "Arbeit", "str3"));
        Map<Integer, List<User>> result = User.groupUsers(users);
        result.forEach((age, usersList) -> System.out.println(age + " " + usersList));
    }
}

