package faang.school.godbless.query;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Main {
    private static HashMap<User, List<Query>> index = new HashMap<>();

    public static void indexQuery(User user, Query query) {
        if (!index.containsKey(user)) {
            index.put(user, new LinkedList<>(List.of(query)));
        } else {
            index.get(user).add(query);
        }
    }

    //удаление пользователя и списка всех его запросов
    public static void deleteUser(User user) {
        index.remove(user);
    }

    //удаление конкретного запроса у какого-то пользователя
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
            for (Query query : index.get(user)) {
                System.out.println(query);
            }
        } else {
            System.out.println(user + " does not exist");
        }
    }

    public static void main(String[] args) {

    }
}
