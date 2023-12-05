package faang.school.godbless.javacore.groupusers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static faang.school.godbless.javacore.groupusers.User.groupUsers;

public class GroupUsersApp {

    public static void main(String[] args) {
        List<User> users = new ArrayList<>();

        users.add(new User("Alice", 25, "Developer", "123 Street A"));
        users.add(new User("Bob", 30, "Designer", "456 Street B"));
        users.add(new User("Charlie", 25, "Artist", "789 Street C"));
        users.add(new User("David", 28, "Engineer", "321 Street D"));
        users.add(new User("Eve", 32, "Manager", "654 Street E"));
        users.add(new User("Frank", 40, "Teacher", "987 Street F"));
        users.add(new User("Grace", 25, "Scientist", "135 Street G"));
        users.add(new User("Henry", 25, "Writer", "246 Street H"));
        users.add(new User("Isabel", 32, "Nurse", "753 Street I"));
        users.add(new User("Jack", 30, "Doctor", "864 Street J"));

        Map<Integer, List<User>> groupedByAge = groupUsers(users);
        System.out.println(groupedByAge);
    }

}