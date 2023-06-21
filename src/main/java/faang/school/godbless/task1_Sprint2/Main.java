package faang.school.godbless.task1_Sprint2;
import java.util.LinkedList;
import java.util.List;

import static faang.school.godbless.task1_Sprint2.User.groupUsers;

public class Main {
    public static void main(String[] args) {

        List<User> users = new LinkedList<>();
        users.add(new User("Alex",20,"Russia","123"));
        users.add(new User("Jon",22,"Russia","123"));
        users.add(new User("Jak",20,"Russia","123"));
        users.add(new User("Bob",20,"Russia","123"));
        users.add(new User("Mark",22,"Russia","123"));

        System.out.println(groupUsers(users));
    }

}
