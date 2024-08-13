package faang.school.godbless.query;

import java.util.*;

public class Main {
    private static HashMap<User, List<Query>> index = new HashMap<>();

    public static void indexQuery(User user, Query query) {
        index.computeIfAbsent(user, k -> new LinkedList<>()).add(query);
    }

    public static void deleteUser(User user) {
        index.remove(user);
    }

    public static void deleteQuery(User user, Query query) {
        if (index.containsKey(user)) {
            index.get(user).remove(query);
        } else {
            System.out.println(user + " does not exist");
        }
    }

    public static void printAllUsersWithQueries() {
        for (Map.Entry<User, List<Query>> entry : index.entrySet()) {
            System.out.println(entry.getKey() + ":");
            for (Query query : entry.getValue()) {
                System.out.println(query);
            }
        }
    }

    public static void printQueryHistory(User user) {
        if (index.containsKey(user)) {
            System.out.println("Query history of " + user + ":");
            List<Query> queries = index.get(user);
            queries.sort((o1, o2) -> {
                if (o1.getTimestamp().after(o2.getTimestamp())) {
                    return 1;
                } else if (o1.getTimestamp() == o2.getTimestamp()) {
                    return 0;
                } else {
                    return -1;
                }
            });
            for (Query query : queries) {
                System.out.println(query);
            }
        } else {
            System.out.println(user + " does not exist");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        indexQuery(new User(1, "Mike"), new Query(1, "Weather in Moscow"));
        Thread.sleep(1000);
        indexQuery(new User(2, "Tom"), new Query(2, "Iphone 15 Pro price"));
        Thread.sleep(1000);
        indexQuery(new User(3, "Kate"), new Query(3, "How to start investing in stocks?"));
        Thread.sleep(1000);
        indexQuery(new User(4, "Helen"), new Query(4, "How to install Python on a Mac?"));
        Thread.sleep(1000);
        indexQuery(new User(1, "Mike"), new Query(5, "Tips for spending time alone"));
        Thread.sleep(1000);
        indexQuery(new User(2, "Tom"), new Query(6, "Where can I go cycling in Paris?"));
        Thread.sleep(1000);
        indexQuery(new User(2, "Tom"), new Query(7, "Which artists influenced Impressionism?"));
        Thread.sleep(1000);
        indexQuery(new User(4, "Helen"), new Query(8, "Best VPN"));
        Thread.sleep(1000);
        indexQuery(new User(1, "Mike"), new Query(9, "Top 100 TV series"));
        Thread.sleep(1000);
        indexQuery(new User(2, "Tom"), new Query(9, "What is artificial intelligence?"));


        deleteUser(new User(3, "Kate"));

        deleteQuery(new User(4, "Helen"), new Query(8, "Best VPN"));

        printAllUsersWithQueries();

        printQueryHistory(new User(1, "Mike"));
    }
}
