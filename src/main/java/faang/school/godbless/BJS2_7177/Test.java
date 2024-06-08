package faang.school.godbless.BJS2_7177;

import java.util.*;

public class Test {
    public static void main(String[] args) {

        List<User> userList = new ArrayList<>();
        Set<String> userActivities = new HashSet<>();
        userActivities.add("Dancing");
        userActivities.add("Cheerleading");
        userActivities.add("Air racing");
        userActivities.add("Archery");
        userActivities.add("Baseball");
        userActivities.add("Hockey");

        Set<String> user1Activities = new HashSet<>();
        user1Activities.add("Dancing");
        user1Activities.add("Hockey");

        Set<String> user2Activities = new HashSet<>();
        user2Activities.add("Baseball");
        Set<String> user3Activities = new HashSet<>();
        user3Activities.add("Rollball");
        Set<String> user4Activities = new HashSet<>();
        user3Activities.add("Aiki-jūjutsu");


        userList.add(new User(0, "John", 33, user1Activities));
        userList.add(new User(1, "Jimmy", 51, user2Activities));
        userList.add(new User(2, "Steve", 14, user3Activities));
        userList.add(new User(3, "Carl", 18, user4Activities));


        Map<User, String> map = User.findHobbyLovers(userList, userActivities);

        for (Map.Entry<User, String> entry : map.entrySet()) {
            System.out.println("User - " + entry.getKey().getName() + " | activity - " + entry.getValue());
        }
    }
}
