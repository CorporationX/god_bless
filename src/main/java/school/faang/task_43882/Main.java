package school.faang.task_43882;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Integer, List<User>> map = User.groupUsers(prepareUser());
        System.out.println(map);
    }

    private static List<User> prepareUser() {
        List<User> list = new ArrayList<>();
        list.add(new User("Alex", 10, "Google", "Wall Street"));
        list.add(new User("Jane", 25, "Facebook", "Avenue 5"));
        list.add(new User("Ben", 14, "Amazon", "Wall Street"));
        list.add(new User("Margaret", 25, "Apple", "Wall Street"));
        list.add(new User("Johny", 10, "Uber", "Avenue 5"));
        return list;
    }
}
