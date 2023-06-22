package faang.school.godbless.sprint2.task_4;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class test {
    public static void main(String[] args) {
        User user1 = new User(1, "Sam", 12, List.of("jump", "run", "swim"));
        User user2 = new User(2, "Jhon", 13, List.of("game", "gum", "studying"));
        User user3 = new User(3, "Luis", 14, List.of("jump", "studying", "swim"));
        User user4 = new User(4, "Tom", 15, List.of("gum", "chess", "swim"));
        List<User> listOfUsers = List.of(user1, user2, user3, user4);
        Set<String> filtre = Set.of("studying", "gum");
        HashMap result = new HashMap();
        result = User.findHobbyLovers(listOfUsers, filtre);
        System.out.println(result.get(user2));
    }
}
