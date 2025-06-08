package school.faang.bjs2_79211;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<User> userList = List.of(new User("Ana", 21), new User("Max", 21),
                                      new User("Dina", 17), new User("Kate", 41),
                                      new User("Den", 31));

        Map<Integer, List<User>> resultUserList = User.groupUsers(userList);

        for (Map.Entry<Integer, List<User>> entry : resultUserList.entrySet()) {
            System.out.print("Age group: " + entry.getKey() + ", users: ");
            for (User user : entry.getValue()) {
                System.out.print(user.getName() + " ");
            }
            System.out.println();
        }
    }
}
