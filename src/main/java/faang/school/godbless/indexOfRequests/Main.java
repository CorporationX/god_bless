package faang.school.godbless.indexOfRequests;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {

    private static final HashMap<User, List<Query>> HISTORY = new HashMap<>();

    public static void main(String[] args) {
        Query query1 = new Query("11aa", "content 1", LocalDateTime.of(2024, 1, 1, 1, 1));
        Query query2 = new Query("11bb", "content 2", LocalDateTime.of(2025, 1, 1, 1,1));

        User user = new User("22bb", "ivan");

        createUserWithQueries(user, List.of(query1));
        addQueryToUser(user, query2);
        System.out.println("all users: " + getAllUsers());
        System.out.println("user history: " + getUserHistory(user));
        deleteUser(user);
        System.out.println("all users: " + getAllUsers());
    }

    public static void createUserWithQueries(User user, List<Query> queryList) {
        Set<Map.Entry<User, List<Query>>> entries = HISTORY.entrySet();
        boolean isExists = false;

        for (Map.Entry<User, List<Query>> entry : entries) {
            if (entry.getKey().equals(user)) {
                isExists = true;
                break;
            }
        }

        if (!isExists) {
            HISTORY.put(user, queryList);
        }
    }

    public static void addQueryToUser(User user, Query query) {
        Set<Map.Entry<User, List<Query>>> entries = HISTORY.entrySet();

        for (Map.Entry<User, List<Query>> entry : entries) {
            if (entry.getKey().getId().equals(user.getId())) {
                List<Query> newList = new ArrayList<>();

                if (entry.getValue() != null) {
                    newList.addAll(entry.getValue());
                }

                newList.add(query);
                entry.setValue(newList);
            }
        }
    }

    public static void deleteUser(User user) {
        Set<Map.Entry<User, List<Query>>> entries = HISTORY.entrySet();

        for (Map.Entry<User, List<Query>> entry : entries) {
            if (entry.getKey().getId().equals(user.getId())) {
                HISTORY.remove(entry.getKey());
                break;
            }
        }
    }

    public static HashMap<User, List<Query>> getAllUsers() {
        return HISTORY;
    }

    public static Map<User, List<Query>> getUserHistory(User user) {
        Map<User, List<Query>> result = new HashMap<>();

        Set<Map.Entry<User, List<Query>>> entries = HISTORY.entrySet();

        for (Map.Entry<User, List<Query>> entry : entries) {
            if (entry.getKey().equals(user)) {
                List<Query> sortedQueries = entry.getValue().stream()
                        .sorted(Comparator.comparing(Query::getTimestamp).reversed())
                        .collect(Collectors.toList());

                result.put(user, sortedQueries);
                break;
            }
        }

        return result;
    }
}