package faang.school.godbless;

import java.util.ArrayList;
import java.util.List;

import static faang.school.godbless.User.groupUsers;

public class Application {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();

        User Bob = new User();
        User Jack = new User();
        User Van = new User();
        User Kate = new User();

        users.add(Bob);
        users.add(Jack);
        users.add(Van);
        users.add(Kate);

        Bob.setAge(20);
        Jack.setAge(30);
        Van.setAge(20);
        Kate.setAge(20);

        System.out.println(User.groupUsers(users));
    }
}