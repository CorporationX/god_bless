package faang.school.godbless.BJS2_4339;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args){
        List<User> users = new ArrayList<>();

        users.add(new User("Anton", 20, "Pyaterochka", "New street"));
        users.add(new User("Andrey", 14, "Null", "Null"));
        users.add(new User("Ekaterina", 20, "Ozon", "Old street"));

        Map<Integer, List<User>> sortedUserMap = User.groupUsers(users);

        for (Map.Entry<Integer,List<User>> entry : sortedUserMap.entrySet()){
            System.out.println("Age: " + entry.getKey());
            for (User user: entry.getValue()){
                System.out.println(user);
            }
        }
    }
}
