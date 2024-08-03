package faang.school.godbless.group_user_by_age;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> userList = new ArrayList<>();
        userList.add(new User("Name", 10, "Job", "Address"));
        userList.add(new User("Name", 20, "Job", "Address"));
        userList.add(new User("Name", 10, "Job", "Address"));
        userList.add(new User("Name", 20, "Job", "Address"));
        userList.add(new User("Name", 10, "Job", "Address"));
        userList.add(new User("Name", 30, "Job", "Address"));

        User.groupUsers(userList);
    }
}
