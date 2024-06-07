package faang.school.godbless.group.users;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User(1, "Almaz", 29, Set.of("Bascet", "Programming", "Anime"), "London", "Google"));
        users.add(new User(2, "Irina", 29, Set.of("Films", "Programming", "Music"), "London", "Google"));
        users.add(new User(3, "Inna", 29, Set.of("Music", "Programming"), "London", "Google"));
        Map<User, String> usersWithHobby = User.createMapWithUsers(users, Set.of("Programming", "Music"));
        for (Map.Entry<User, String> user : usersWithHobby.entrySet()) {
            System.out.println(String.format("User: %s, Hobby: %s", user.getKey().getName(), user.getValue()));
        }
    }
}
