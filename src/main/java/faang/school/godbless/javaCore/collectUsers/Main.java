package faang.school.godbless.javaCore.collectUsers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();

        List<String> hobbies = new ArrayList<>();
        hobbies.add("Domino");
        hobbies.add("Football");
        hobbies.add("Tennis");
        hobbies.add("Basketball");
        hobbies.add("Chess");

        HashSet<String> activitiesToTest1 = new HashSet<>();
        activitiesToTest1.add("Volleyball");
        activitiesToTest1.add("Domino");
        activitiesToTest1.add("Ski");
        activitiesToTest1.add("Run");


        HashSet<String> activitiesToTest2 = new HashSet<>();
        activitiesToTest2.add("Football");
        activitiesToTest2.add("Rally");
        activitiesToTest2.add("Tennis");
        activitiesToTest2.add("Jumps");

        User user1 = new User(1,"Alex",25, activitiesToTest1);
        User user2 = new User(2,"John",31, activitiesToTest2);

        users.add(user1);
        users.add(user2);

        HashMap<User, String> findUsers = (HashMap<User, String>) User.findHobbyLovers(users,hobbies);

        for (Map.Entry<User, String> map : findUsers.entrySet()){
            User user = map.getKey();
            String userName = user.getName();
            String userHobby = map.getValue();

            System.out.println(userName + " - " + userHobby);
        }
    }

}
