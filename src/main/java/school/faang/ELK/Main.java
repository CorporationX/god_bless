package school.faang.ELK;

import java.util.*;

import static school.faang.ELK.queryService.*;

public class Main {
    private static final Map<User, List<Query>> users = new HashMap<>();

    public static void main(String[] args) {
        User user1 = new User(1, "User1");
        User user2 = new User(2, "User2");
        User user3 = new User(3, "User3");

        Query query1 = new Query(1, "Some Content");
        Query query2 = new Query(2, "Some Content");
        Query query3 = new Query(3, "Some Content");

        addUser(user1, new ArrayList<>(List.of(query1, query2)), users);
        addUser(user2, new ArrayList<>(List.of(query2, query3)), users);
        addUser(user3, new ArrayList<>(List.of(query1, query3)), users);

        printUsers(users);

        addQueryToUser(user1, query3, users);
        removeUser(user2, users);

        printUsers(users);
    }
}