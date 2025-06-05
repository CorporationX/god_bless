package school.faang.bjs2_79211;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        User ana = new User("Ana", 21);
        User max = new User("Max", 21);
        User dina = new User("Dina", 17);
        User kate = new User("Kate", 41);
        User den = new User("Den", 31);

        List<User> userList = new ArrayList<>();
        userList.add(ana);
        userList.add(max);
        userList.add(dina);
        userList.add(kate);
        userList.add(den);

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
