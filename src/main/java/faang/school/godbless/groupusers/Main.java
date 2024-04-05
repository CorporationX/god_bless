package faang.school.godbless.groupusers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("Tom", 21, "Vk", "123 Eb st."));
        users.add(new User("Bob", 19, "Uber", "Flemming st. 21"));
        users.add(new User("Ann", 23, "Nike", "Elm st. 13"));
        users.add(new User("Mary", 21, "Puma", "415 Hell st."));
        Map<Integer, List<User>> group = User.groupUsers(users);
        System.out.println(group);
    }
}
