package GroupUsers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {
        List<User> userList = new ArrayList<>();
        userList.add(new User("Ivan", 19, "BootCamp", "Kazan"));
        userList.add(new User("Kolya", 19, "BootCamp", "Kazan"));
        userList.add(new User("Kirill", 19, "BootCamp", "Kazan"));
        userList.add(new User("Sasha", 20, "BootCamp", "Kazan"));
        userList.add(new User("Max", 20, "BootCamp", "Kazan"));
        userList.add(new User("Marat", 20, "BootCamp", "Kazan"));

        Map<Integer, List<User>> test = User.groupUsers(userList);

        for(Map.Entry<Integer, List<User>> pair : test.entrySet()){
            System.out.println(pair.getKey() + " : " + pair.getValue());
        }

    }
}
