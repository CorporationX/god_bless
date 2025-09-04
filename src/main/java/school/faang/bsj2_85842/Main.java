package school.faang.bsj2_85842;

import java.util.ArrayList;
//import java.util.HashMap;
import java.util.Map;


public class Main {
    public static void main(String[] args) {
        User user1 = new User("Name1", 25, "Restaurant", "1st Street, 15");
        User user2 = new User("Name2", 26, "Bar", "2nd Street, 16");
        User user3 = new User("Name3", 27, "Hotel", "3rd Street, 17");
        User user4 = new User("Name4", 25, "Spa", "4th Street, 18");
        ArrayList<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        Map<Integer, ArrayList<User>> resultMap = User.groupUsers(users);
        System.out.println(resultMap);
    }
}
