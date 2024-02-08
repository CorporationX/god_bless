package faang.school.godbless.group.users;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User(1, "Almaz", 29, Set.of("Bascet", "Programming", "Anime")));
        users.add(new User(1, "Irina", 29, Set.of("Films", "Programming", "Music")));
        users.add(new User(1, "Inna", 29, Set.of("Music", "Programming")));
        Map<User, String> usersWithHobby = User.createMapWithUsers(users, Set.of("Programming", "Music"));
        for (Map.Entry<User, String> user : usersWithHobby.entrySet()) {
            System.out.println(String.format("User: %s, Hobby: %s", user.getKey().getName(), user.getValue()));
        }
    }
}
