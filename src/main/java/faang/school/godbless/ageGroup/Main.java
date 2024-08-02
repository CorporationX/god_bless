package faang.school.godbless.ageGroup;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> user = new ArrayList<>();
        user.add(new User ("Alex", 27, "Analyst", "Broadway"));
        user.add(new User("Anna", 25, "Developer", "Maple Avenue"));
        user.add(new User("John", 30, "Designer", "Oak Street"));
        user.add(new User ("Maria", 22, "Tester", "Pine Lane"));
        user.add(new User("David", 28, "Manager", "Cedar Road"));

        var result = User.groupUsers(user);

        result.entrySet().forEach(System.out::println);
    }
}
