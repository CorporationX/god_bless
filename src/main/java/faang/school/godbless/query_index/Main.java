package faang.school.godbless.query_index;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static Map<User, List<Query>> userQueryMap = new HashMap<>();

    public static void main(String[] args) {
        User varya = new User(1, "Varya");
        User anna = new User(2, "Anna");

        List<Query> queryList = new ArrayList<>(List.of(new Query(1, "content", Instant.now())));
        detainTime();
        queryList.add(new Query(2, "content2", Instant.now()));
        detainTime();
        queryList.add(new Query(3, "content3", Instant.now()));


        addUserWithQueryList(varya, queryList);

        addQueryToUser(varya, new Query(4, "content4", Instant.now()));

        addUserWithQueryList(anna, queryList);
        removeUserWithQueryList(varya);

        addUserWithQueryList(varya, queryList);
        printAllUsersWithQueryLists();

        printUserQueryHistory(varya);
    }


    public static void addUserWithQueryList(User user, List<Query> queryList) {
        userQueryMap.put(user, queryList);
    }

    public static void addQueryToUser(User user, Query query) {
        userQueryMap.get(user).add(query);
    }

    public static void removeUserWithQueryList(User user) {
        userQueryMap.remove(user);
    }

    public static void printAllUsersWithQueryLists() {
        userQueryMap.entrySet().forEach(System.out::println);
    }

    public static void printUserQueryHistory(User user) {
        List<Query> queryList = userQueryMap.get(user);
        Collections.sort(queryList);
        System.out.println(user + " - " + queryList);
    }

    private static void detainTime() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
