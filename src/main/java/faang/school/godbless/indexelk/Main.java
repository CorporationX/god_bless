package faang.school.godbless.indexelk;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final Map<User, List<Query>> userMap = new HashMap<>();

    public static void addUser(User user, List<Query> queryList) {
        userMap.put(user, queryList);
    }

    public static void addQuery(User user, Query query) {
        if (userMap.containsKey(user)) {
            userMap.get(user).add(query);
        } else {
            System.out.println("Пользователь не найден");
        }
    }

    public static void removeUser(User user) {
        if (userMap.containsKey(user)) {
            userMap.remove(user);
        } else {
            System.out.println("Такого пользователя не существует");
        }
    }

    public static void printAllUsersAndQueries() {
        for (User user : userMap.keySet()) {
            System.out.println("user: " + user);
            System.out.println(
                    userMap.get(user).stream()
                            .map(query -> "   query id: " + query.getId()
                                    + "; content: " + query.getContent()
                                    + "; timestamp: " + query.getTimestamp() + "\r\n")
                            .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                            .toString()
            );
        }
    }

    public static void printUserQueriesSorted(User user) {
        if (userMap.containsKey(user)) {
            userMap.get(user).stream()
                    .sorted(Comparator.comparing(Query::getTimestamp))
                    .forEach(System.out::println);
        } else {
            System.out.println("Такого пользователя не существует");
        }
    }

    public static void main(String[] args) {
        System.out.println("add new user");
        addUser(new User(0, "user0"),
                new ArrayList<>(){{
                    add(new Query(0,"content0", LocalDateTime.now()));
                    add(new Query(1,"content1", LocalDateTime.now()));
                    add(new Query(2,"content2", LocalDateTime.now()));
                    add(new Query(3,"content3", LocalDateTime.now()));
                }});
        addUser(new User(1, "user1"),
                new ArrayList<>(){{
                    add(new Query(0,"content4", LocalDateTime.now()));
                    add(new Query(1,"content5", LocalDateTime.now()));
                    add(new Query(2,"content6", LocalDateTime.now()));
                    add(new Query(3,"content7", LocalDateTime.now()));
                }});
        addUser(new User(2, "user2"),
                new ArrayList<>(){{
                    add(new Query(0,"content8", LocalDateTime.now()));
                    add(new Query(1,"content9", LocalDateTime.now()));
                    add(new Query(2,"contentA", LocalDateTime.now()));
                    add(new Query(3,"contentB", LocalDateTime.now()));
                }});
        printAllUsersAndQueries();

        System.out.println();

        System.out.println("add new query to existing user (user1 and user2):");
        addQuery(new User(1, "user1"), new Query(4, "contentC", LocalDateTime.now()));
        addQuery(new User(2, "user2"), new Query(4, "contentD", LocalDateTime.now()));
        System.out.println("user1:");
        printUserQueriesSorted(new User(1, "user1"));
        System.out.println("user2:");
        printUserQueriesSorted(new User(2, "user2"));

        System.out.println();

        System.out.println("remove user with id = 1:");
        removeUser(new User(1, "user1"));

        System.out.println();

        System.out.println("print all users and queries (user with id = 1) was deleted:");
        printAllUsersAndQueries();

        System.out.println();

        System.out.println("print user queries sorted:");
        printUserQueriesSorted(new User(2, "user2"));
    }
}
