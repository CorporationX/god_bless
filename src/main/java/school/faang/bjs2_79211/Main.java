package school.faang.bjs2_79211;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        User Ana = new User("Ana", 21);
        User Max = new User("Max", 21);
        User Dina = new User("Dina", 17);
        User Kate = new User("Kate", 41);
        User Den = new User("Den", 31);

        List<User> userList = new ArrayList<>();
        userList.add(Ana);
        userList.add(Max);
        userList.add(Dina);
        userList.add(Kate);
        userList.add(Den);

        Map<Integer, List<User>> resultUserList = User.groupUsers(userList);

        for (Map.Entry<Integer, List<User>> entry : resultUserList.entrySet()) {
            System.out.print("Age group: " + entry.getKey() + ", users: ");
            for (User user : entry.getValue()) {
                System.out.print(user.getName());
            }
            System.out.println();
        }
    }
}
