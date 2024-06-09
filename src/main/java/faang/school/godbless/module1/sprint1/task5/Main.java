package faang.school.godbless.module1.sprint1.task5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static final Set<String > ACTIVITIES = Set.of("Football", "Moto", "Photography", "Music");
    public static final List<User> USERS = new ArrayList<>();
    public static void main(String[] args) {
        USERS.add(new User(1L,"Alex",18,Set.of("Moto","Swim")));
        USERS.add(new User(2L,"Max",30,Set.of("Music","Drink")));
        USERS.add(new User(3L,"Lana",31,Set.of("Photography","Football")));
        USERS.add(new User(4L,"Max",30,Set.of("Music","Moto")));

        System.out.println(findHobbyLovers(USERS,ACTIVITIES));

    }

    public static Map<User,String> findHobbyLovers(List<User> users, Set<String> activities) {
        Map<User,String> hobbyLovers = new HashMap<>();
        for (String activity : activities) {
            for (User user : users) {
                if (user.getHobbies().contains(activity)) {
                    hobbyLovers.put(user,activity);
                }
            }
        }
        return hobbyLovers;
    }
}
