package faang.school.godbless.CollectUsers;

import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        User user1 = new User();
        user1.setId(1L);
        user1.setName("TestName1");
        user1.setAge(2);
        user1.setActivities(Set.of("baseball","soccer","programming"));

        User user2 = new User();
        user2.setId(2L);
        user2.setName("TestName2");
        user2.setAge(2);
        user2.setActivities(Set.of("soccer","programming"));

        List<User> users = List.of(user1,user2);
        Set<String> activities = Set.of("baseball","soccer","programming");

        System.out.println(User.findHobbyLovers(users,activities));

    }

}
