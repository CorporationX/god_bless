package faang.school.godbless.Maps.BJS2_20011;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    private static Map<User, List<Query>> queryMap = new HashMap<>();

    public static void main(String[] args) throws InterruptedException {

        Query third = new Query("third");
        Thread.sleep(500);
        Query first = new Query("first");
        Thread.sleep(500);
        Query fourth = new Query("fourth");
        Thread.sleep(500);
        Query second = new Query("second");

        User tom = new User("Tom");
        addQuery(tom, fourth);
        addQuery(tom, first);
        addQuery(tom, second);
        addQuery(tom, third);

        User bob = new User("Bob");
        List<Query> list = new ArrayList<>();
        list.add(first);
        list.add(second);
        list.add(third);
        list.add(fourth);
        addQuery(bob, list);

        printAllUsersQueries();
    }

    public static void addQuery(User user, Query query) {
        queryMap.put(user, user.addQuery(query));
    }

    public static void addQuery(User user, List<Query> list) {
        queryMap.put(user, user.addQuery(list));
    }

    public static void removeSubject(User user) {
        queryMap.remove(user);
    }

    public static void printUserQueries(User user) {
        System.out.println("#" + user.getId() + ":" + user.getName());
        for (Query query : user.getSortedQuryList()) {
            System.out.println(query.getId() + ":" + query.getContent() + "::" + query.getTimestamp());
        }
    }

    public static void printAllUsersQueries() {
        for (Map.Entry<User, List<Query>> entry : queryMap.entrySet()) {
            System.out.println("=======");
            System.out.println(entry.getKey().getName());
            printUserQueries(entry.getKey());
            System.out.println("=======");
        }
    }
}
