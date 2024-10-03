package school.faang;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("Dima", 24, "Apple" , "USA"));
        users.add(new User("Misha", 31, "Amazon" , "London"));
        users.add(new User("Kesha", 24, "Sber" , "Moscow"));
        Map<Integer, List<User>> groupedUsers= User.groupUsers(users);
        for (Map.Entry<Integer, List<User>> entry : groupedUsers.entrySet()){
            System.out.println("Age: " + entry.getKey()+ " Users" + entry.getValue());
        }


    }
}
