package faang.school.godbless.bjs220088;

import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<User, List<Query>> indexedQueries = new HashMap<>();
        UserQueryService userQueryService = new UserQueryService();
        User user1 = new User(1, "Alice");
        User user2 = new User(2, "Bob");

        Query query1User1 = new Query(1, "How to learn Java?", Instant.now());
        Query query2User1 = new Query(2, "Best Java practices", Instant.now().plusSeconds(20));

        Query query1User2 = new Query(3, "What is OOP?", Instant.now().plusSeconds(15));
        Query query2User2 = new Query(4, "Java vs Python", Instant.now().plusSeconds(5));

        userQueryService.addUserQuery(indexedQueries, user1, query1User1);
        userQueryService.addUserQuery(indexedQueries, user1, query2User1);
        userQueryService.addUserQuery(indexedQueries, user2, query1User2);
        userQueryService.addUserQuery(indexedQueries, user2, query2User2);

        userQueryService.printAllUsersQueries(indexedQueries);
        userQueryService.printUserQueries(indexedQueries, user2);

        userQueryService.deleteUser(indexedQueries, user2);
        userQueryService.printAllUsersQueries(indexedQueries);
    }
}
