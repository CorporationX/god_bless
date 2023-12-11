package faang.school.godbless.java_hashmap.index_request_elk;

import java.time.LocalDateTime;
import java.util.*;

public class Main {

    private static final Map<User, List<Query>> userQueryMap = new HashMap<>();

    public static void main(String[] args) {

        Query q1 = new Query(1, "Content 1", LocalDateTime.now());
        Query q2 = new Query(2, "Content 2", LocalDateTime.now().minusDays(1));
        Query q3 = new Query(3, "Content 3", LocalDateTime.now().minusDays(2));
        Query q4 = new Query(4, "Content 4", LocalDateTime.now().minusDays(3));
        Query q5 = new Query(5, "Content 5", LocalDateTime.now().minusDays(4));
        Query q6 = new Query(6, "Content 6", LocalDateTime.now().minusDays(5));
        Query q7 = new Query(7, "Content 7", LocalDateTime.now().minusDays(6));
        Query q8 = new Query(8, "Content 8", LocalDateTime.now().minusDays(7));
        Query q9 = new Query(9, "Content 9", LocalDateTime.now().minusDays(8));
        Query q10 = new Query(10, "Content 10", LocalDateTime.now().minusDays(9));

        addNewUserWithQueries(new User(1, "User_1"), new ArrayList<>(List.of(q1, q2, q3)));
        addNewUserWithQueries(new User(2, "User_2"), new ArrayList<>(List.of(q4, q5, q6)));
        addNewUserWithQueries(new User(3, "User_3"), new ArrayList<>(List.of(q7, q8)));
        addNewUserWithQueries(new User(4, "User_4"), new ArrayList<>(List.of(q9, q10)));

        addNewQueryForUser(new User(1, "User_1"), new Query(11, "Content 11", LocalDateTime.now().minusDays(10)));
        remove(new User(1, "User_1"));
        printUserWithQueries();

        printHistoryUser(new User(2, "User_2"));


    }


    static void addNewUserWithQueries(User user, List<Query> queries) {
        if (user == null || queries == null) throw new IllegalArgumentException("args is null");
        userQueryMap.put(user, queries);
    }


    static void addNewQueryForUser(User user, Query query) {
        List<Query> queries = userQueryMap.get(user);
        if (queries == null) {
            System.out.println("User not found: " + user);
        } else {
            queries.add(query);
        }
    }

    static void remove(User user) {
        if (userQueryMap.remove(user) != null) {
            System.out.println("User deleted: " + user);
        } else {
            System.out.println("User not found: " + user);
        }
    }

    static void printUserWithQueries() {
        userQueryMap.entrySet().stream().forEach(entry -> {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        });
    }


    static void printHistoryUser(User user) {
        System.out.println(user + " : " + userQueryMap.get(user).stream().sorted((q1, q2) -> q2.getTimestamp().compareTo(q1.getTimestamp())).toList());
    }


}
