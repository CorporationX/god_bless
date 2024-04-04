package faang.school.godbless.BJS2_4338;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args){
        List<User> users = new ArrayList<>();

        users.add(new User("Anton", 20, "Google", "London"));
        users.add(new User("Andrey", 19, "Uber", "New York"));
        users.add(new User("Ekaterina", 20, "Amazon", "Amsterdam"));

        Map<Integer, List<User>> sortedUserMap = User.groupUsers(users);

        for (Map.Entry<Integer,List<User>> entry : sortedUserMap.entrySet()){
            System.out.println("Age: " + entry.getKey());
            for (User user: entry.getValue()){
                System.out.println(user);
            }
        }
    }
}