package faang.school.godbless.userregistration;

import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        List<User> listUsers = new ArrayList<>();
        listUsers.add(new User("Петя", 20, "Uber", "New York"));
        listUsers.add(new User("Ваня", 20, "Google", "Amsterdam"));
        listUsers.add(new User("Вася", 22, "Amazon", "London"));

        System.out.println(User.groupUsers(listUsers));
    }
}
