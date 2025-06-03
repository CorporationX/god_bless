package school.faang.bjs2_79179;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<User> userList = new ArrayList<>();
        userList.add(new User("alex", 21, "NASA", "wall street"));
        userList.add(new User("myrza", 22, "", ""));
        userList.add(new User("asem", 23, "", ""));
        userList.add(new User("arman", 21, "", ""));
        userList.add(new User("anton", 23, "", ""));
        userList.add(new User("gena", 21, "", ""));
        userList.add(new User("tolqyn", 22, "", ""));
        Map<Integer, List<User>> userMap = User.groupUsers(userList);
        for (Map.Entry<Integer, List<User>> entry : userMap.entrySet()) {
            System.out.printf("age: %d\n", entry.getKey());
            System.out.println(entry.getValue());
        }
    }
}
