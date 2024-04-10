package elk;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    private static final Map<User, List<Query>> USER_QUERIES = new HashMap<>();

    public static void main(String[] args) {

        List<Query> queries = new ArrayList<>();
        User user1 = new User("Nick");
        Query query1 = new Query("ss", new Date(1212121212121L));
        Query query2 = new Query("aa", new Date(1200000000000L));
        queries.add(query1);
        queries.add(query2);
        addUserWithQueryList(user1, queries);
        addQueryInList(user1, new Query("zz", new Date(100000000L)));


        queries = new ArrayList<>();
        User user2 = new User("Paul");
        Query query12 = new Query("bb", new Date(121212121212L));
        Query query22 = new Query("cc", new Date(121212120000L));
        queries.add(query12);
        queries.add(query22);
        addUserWithQueryList(user2, queries);

        //Вывод всех пользователей и их запросов
        printAllUsersAndQueryList();

        //Сортировка запросов User1 по времени
        printUserWithQueryListSortedByTime(user1);

        //Удаление пользователя
        removeUserAndQueriesList(user1);
        printAllUsersAndQueryList();
    }

    public static void addUserWithQueryList(User user, List<Query> queries) {
        checkUserIsNotNull(user);
        USER_QUERIES.put(user, queries);
    }

    public static void addQueryInList(User user, Query query) {
        checkUserIsNotNull(user);
        USER_QUERIES.get(user).add(query);
    }

    public static void removeUserAndQueriesList(User user) {
        checkUserIsNotNull(user);
        USER_QUERIES.remove(user);
    }

    public static void printAllUsersAndQueryList() {
        USER_QUERIES.forEach((user, queries) -> {
            System.out.println("Name: " + user.getName());
            queries.forEach(Main::printQuery);
            System.out.println("=====================\n");
        });
    }

    public static void sortAllQueriesAtUserByTime(User user) {
        checkUserIsNotNull(user);
        USER_QUERIES.get(user).sort(Comparator.comparing(Query::getTimestamp));
    }

    public static void printUserWithQueryListSortedByTime(User user) {
        checkUserIsNotNull(user);
        sortAllQueriesAtUserByTime(user);
        System.out.println("User: " + user.getName() + "\n");
        USER_QUERIES.get(user).forEach(Main::printQuery);
        System.out.println("==========================\n");
    }

    private static void checkUserIsNotNull(User user) {
        if (user == null) {
            throw new NullPointerException("Пользователь не существует");
        }
    }

    private static void printQuery(Query query) {
        System.out.println("Query id: " + query.getId() +
                "\nContent: " + query.getContent() +
                "\nTimestamp: " + query.getTimestamp() + "\n");
    }
}
