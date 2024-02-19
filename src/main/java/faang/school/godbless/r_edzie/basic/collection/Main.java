package faang.school.godbless.r_edzie.basic.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<String> activitiesMock = Set.of("programming", "gaming");
        Set<String> activitiesMock2 = Set.of("sleeping", "eating");
        Set<String> activitiesMock3 = Set.of("eating", "living");
        Set<String> activitiesMock4 = Set.of("programming", "living");

        User u1 = new User("Alex", activitiesMock);
        User u2 = new User("Peter", activitiesMock2);
        User u3 = new User("Jon", activitiesMock3);
        User u4 = new User("Joe", activitiesMock4);

        List<User> userList = new ArrayList<>();

        userList.add(u1);
        userList.add(u2);
        userList.add(u3);
        userList.add(u4);

        Set<String> activities = Set.of("programming", "gaming");

        for(Map.Entry<User, String> entry : (u1.findHobbyLovers(userList, activities)).entrySet()){
            User user = entry.getKey();
            String activity = entry.getValue();
            System.out.println(user.getName() + " " + activity);
        }
    }
}
