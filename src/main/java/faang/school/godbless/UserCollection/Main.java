package faang.school.godbless.UserCollection;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<User>();

        users.add(new User("valera", 12, "pushkina-kolotushkina", "a", Set.of("gta", "dota")));
        users.add(new User("danya", 12, "pushkina-kolotushkina", "a", Set.of("dota", "lol")));
        users.add(new User("alex", 12, "pushkina-kolotushkina", "a", Set.of("cs")));
        users.add(new User("arkadiy", 12, "pushkina-kolotushkina", "a", Set.of("gym")));

        Map<User, String> activitiesLovers = User.getHobbyLovers(users, Set.of("dota", "cs"));

        activitiesLovers.forEach((user, activity) ->
        {
            System.out.println(user.getName() + " " + activity);
        });
    }
}
