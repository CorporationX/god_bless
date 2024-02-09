package Task4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        User user1 = new User(1,"sam",22,Set.of("football", "book", "music"));
        User user2 = new User(2,"tom",24,Set.of("it", "dance", "films"));
        ArrayList<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        Set<String> set = Set.of("book","game","it");
        Map<User, String> hobbyLovers = user1.findHobbyLovers(users, set);
        System.out.println(hobbyLovers);
    }
}
