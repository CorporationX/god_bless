package Task2;

import java.util.ArrayList;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        User user1 = new User("Vasya", 23);
        User user2 = new User("Vanya", 9);
        User user3 = new User("Nikita", 23);
        ArrayList<User> list1 = new ArrayList<>();
        list1.add(user1);
        list1.add(user2);
        list1.add(user3);

        Map<Integer, ArrayList<User>> mapOfUsers = User.groupUsers(list1);
        System.out.println(mapOfUsers);
    }
}
