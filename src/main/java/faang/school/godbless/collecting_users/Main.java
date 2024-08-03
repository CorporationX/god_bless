package faang.school.godbless.collecting_users;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<String> activitySet = Set.of("qwe", "asd", "zxc");

        List<User> userList = new ArrayList<>();
        userList.add(new User(1, "Varya", 20, Set.of("qwe", "asd", "zxc")));
        userList.add(new User(2, "Anna", 20, Set.of("wer", "sdf", "zxc")));
        userList.add(new User(3, "Masha", 20, Set.of("wer", "sdf", "xcv")));

        User.findHobbyLovers(userList, activitySet);
    }
}
