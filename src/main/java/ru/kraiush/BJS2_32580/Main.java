package ru.kraiush.BJS2_32580;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final Map<User, List<Query>> USERS_QUERIES = new HashMap<>();

    private static void addUserAndQueries(User user, List<Query> queries) {
        USERS_QUERIES.put(user, queries);
    }

    private static void addQueryToUserQueryList(User user, Query query) {
        USERS_QUERIES.get(user).add(query);
    }

    private static void deleteUserAndQueries(User user) {
        USERS_QUERIES.remove(user);
    }

    private static void getUsersAndQueries() {
        for (Map.Entry<User, List<Query>> entry: USERS_QUERIES.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    private static void getUserQueryListSortedByTime(User user) {
        List<Query> userQueriesSortedQByTime = USERS_QUERIES.get(user).stream().sorted(Comparator.comparing(Query::getTimestamp)).toList();
        System.out.println(user.getName() + ": \n" + "Queries: ");
        for (Query query : userQueriesSortedQByTime) {
            System.out.println("Id = " + query.getId() + ", Content: " + query.getContent() + ", Time: " + query.getTimestamp());
        }
    }

    public static void main(String[] args) {
        User user1 = new User(1, "Steve");
        User user2 = new User(2, "Chris");
        User user3 = new User(3, "Emma");

        List<Query> user1List = new ArrayList<>();
        user1List.add(new Query(1, "How to implement multithreading in Java?", LocalDateTime.of(2022, 3, 15, 10, 30)));
        user1List.add(new Query(4, "Difference between Java 8 and Java 11", LocalDateTime.of(2023, 1, 5, 17, 35)));
        user1List.add(new Query(5, "How to configure Spring Boot application in Java?", LocalDateTime.of(2023, 3, 25, 12, 50)));
        user1List.add(new Query(7, "How to connect a Java application to PostgreSQL database?", LocalDateTime.of(2023, 5, 18, 16, 10)));
        user1List.add(new Query(9, "How to create a REST API using Spring Boot?", LocalDateTime.of(2022, 11, 21, 13, 40)));

        List<Query> user2List = new ArrayList<>();
        user2List.add(new Query(2, "What is the difference between HashMap and Hashtable?", LocalDateTime.of(2022, 6, 10, 14, 45)));
        user2List.add(new Query(6, "How to handle exceptions using try-catch in Java?", LocalDateTime.of(2022, 8, 14, 11, 15)));
        user2List.add(new Query(10, "How to use Optional in Java for null safety?", LocalDateTime.of(2023, 7, 30, 15, 55)));

        List<Query> user3List = new ArrayList<>();
        user3List.add(new Query(3, "Best practices for using Stream API in Java", LocalDateTime.of(2022, 9, 12, 8, 20)));
        user3List.add(new Query(8, "What is the purpose of lambda expressions in Java?", LocalDateTime.of(2023, 2, 10, 9, 5)));

        Query query11 = new Query(11, "How to implement Singleton pattern in Java?", LocalDateTime.of(2023, 5, 12, 14, 30));
        Query query12 = new Query(12, "What is the best way to read files in Java?", LocalDateTime.of(2022, 11, 19, 9, 45));
        Query query13 = new Query(13, "How to perform unit testing with JUnit in Java?", LocalDateTime.of(2023, 3, 8, 11, 15));
        Query query14 = new Query(14, "How to optimize memory usage in Java applications?", LocalDateTime.of(2022, 12, 27, 17, 50));
        Query query15 = new Query(15, "What is the difference between ArrayList and LinkedList?", LocalDateTime.of(2023, 4, 22, 8, 20));

        addUserAndQueries(user1, user1List);
        addUserAndQueries(user2, user2List);
        addUserAndQueries(user3, user3List);
        getUsersAndQueries();

        addQueryToUserQueryList(user1, query11);
        addQueryToUserQueryList(user2, query12);
        addQueryToUserQueryList(user2, query13);
        addQueryToUserQueryList(user3, query14);
        addQueryToUserQueryList(user3, query15);
        getUsersAndQueries();

        deleteUserAndQueries(user1);
        getUsersAndQueries();

        getUserQueryListSortedByTime(user3);
    }
}
