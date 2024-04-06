package elk;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    private static final Map<User, List<Query>> USER_QUERY_LIST = new HashMap<>();

    public static void main(String[] args) {

        List<Query> queries = new ArrayList<>();
        User user1 = new User(1, "Nick");
        Query query1 = new Query(1, "ss", new Date(1212121212121L));
        Query query2 = new Query(2, "aa", new Date(1200000000000L));
        queries.add(query1);
        queries.add(query2);
        addUserWithQueryList(user1, queries);
        addQueryInList(user1, new Query(3, "zz", new Date(100000000L)));


        queries = new ArrayList<>();
        User user2 = new User(4, "Paul");
        Query query12 = new Query(5, "bb", new Date(121212121212L));
        Query query22 = new Query(6, "cc", new Date(121212120000L));
        queries.add(query12);
        queries.add(query22);
        addUserWithQueryList(user2, queries);

        //Вывод всех пользователей и их запросов
        printAllUsersAndQueryList();

        //Сортировка запросов User1 по времени
        printUserWithQueryList(user1);

        //Удаление пользователя
        removeUserAndQueriesList(user1);
        printAllUsersAndQueryList();
    }

    public static void addUserWithQueryList(User user, List<Query> queries) {
        USER_QUERY_LIST.put(user, queries);
    }

    public static void addQueryInList(User user, Query query) {
        List<Query> tmp = USER_QUERY_LIST.get(user);
        tmp.add(query);
        USER_QUERY_LIST.put(user, tmp);
    }

    public static void removeUserAndQueriesList(User user) {
        USER_QUERY_LIST.remove(user);
    }

    public static void printAllUsersAndQueryList() {
        for (Map.Entry<User, List<Query>> entry : USER_QUERY_LIST.entrySet()) {
            printUserWithQueryList(entry.getKey());
        }
    }

    public static void sortAllQueriesAtUserByTime(User user) {
        USER_QUERY_LIST.get(user).sort(Comparator.comparing(Query::getTimestamp));
    }

    public static void printUserWithQueryList(User user) {
        sortAllQueriesAtUserByTime(user);
        System.out.println("User: " + user.getName() + "\n");
        for (Query query : USER_QUERY_LIST.get(user)) {
            System.out.println("Query id: " + query.getId() +
                    "\nContent: " + query.getContent() +
                    "\nTimestamp: " + query.getTimestamp() + "\n");
        }
        System.out.println("==========================\n");
    }
}
