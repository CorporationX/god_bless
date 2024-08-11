package faang.school.godbless.Index_ELK;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static Map<User, List<Query>> mapOfQuery = new HashMap<>();

    public static void addNewUser(User user) {
        List<Query> queryList = new ArrayList<>();
        mapOfQuery.put(user, queryList);
    }

    public static void addNewRequestInQuery(User user, Query query) {
        for (User userOfMap : mapOfQuery.keySet()) {
            if (userOfMap.equals(user)) {
                mapOfQuery.get(userOfMap).add(query);
            }
        }
    }

    public static void removeUser(User user) {
        mapOfQuery.remove(user);
    }

    public static void printAllUserQuery() {
        for (Map.Entry<User, List<Query>> entry : mapOfQuery.entrySet()) {
            System.out.println("Пользователь с ником:" + entry.getKey().getName());
            System.out.println("Его запросы:");
            for (Query query : entry.getValue()) {
                System.out.println(query.getContent());
                System.out.println("Время запроса:" + query.getTimestamp());
            }
        }
    }

    public static void sortUserQuery(User user) {
        Map<Long, Query> sortedQueryMap = new TreeMap<>();
        for (Query query : mapOfQuery.get(user)) {
            sortedQueryMap.put(query.getTimestamp(), query);
        }
        for (Map.Entry<Long, Query> entry : sortedQueryMap.entrySet()) {
            System.out.println("Время запроса:" + entry.getKey() + " Запрос:" + entry.getValue().getContent());
        }
    }

    public static void main(String[] args) {
        User user1 = new User(14245345, "Brian");
        User user2 = new User(14245346, "Sarah");
        User user3 = new User(14245347, "Michael");
        User user4 = new User(14245348, "Jessica");
        User user5 = new User(14245349, "David");
        addNewUser(user1);
        addNewUser(user2);
        addNewUser(user3);
        addNewUser(user4);
        addNewUser(user5);
        Query query1 = new Query(25, "Local restaurants in Texas", 1);
        Query query2 = new Query(26, "Best hiking trails in California", 2);
        Query query3 = new Query(27, "Top tourist spots in New York", 3);
        Query query4 = new Query(28, "Weather forecast for Seattle", 4);
        Query query5 = new Query(29, "Famous museums in Paris", 5);
        Query query6 = new Query(30, "Coffee shops in San Francisco", 6);
        Query query7 = new Query(31, "Upcoming tech events", 7);
        Query query8 = new Query(32, "Best beaches in Florida", 8);
        Query query9 = new Query(33, "Public transport in London", 9);
        Query query10 = new Query(34, "Popular movies in 2024", 10);
        addNewRequestInQuery(user1, query2);
        addNewRequestInQuery(user1, query1);
        addNewRequestInQuery(user2, query4);
        addNewRequestInQuery(user2, query3);
        addNewRequestInQuery(user3, query6);
        addNewRequestInQuery(user3, query5);
        addNewRequestInQuery(user4, query8);
        addNewRequestInQuery(user4, query7);
        addNewRequestInQuery(user5, query10);
        addNewRequestInQuery(user5, query9);
        printAllUserQuery();
        sortUserQuery(user1);
        removeUser(user5);
        printAllUserQuery();

    }
}
