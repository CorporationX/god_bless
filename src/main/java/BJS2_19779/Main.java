package BJS2_19779;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {
        Map<User, List<Query>> userQueries = new HashMap<>();
        User user = new User(1, "Masha");
        List<Query> mashaList = List.of(new Query(1, "How to make sandwich?", LocalDateTime.now()),
                new Query(2, "Where to study in Berlin?", LocalDateTime.now()),
                new Query(3, "Restaurants in Berlin rating", LocalDateTime.now()));
        userQueries.put(user, mashaList);

        User userTest = new User(2, "Sergey");
        List<Query> sergeyList = new ArrayList<>();
        sergeyList.add(new Query(1, "Where to go boxing?", LocalDateTime.now()));
        Query queryTest = new Query(5, "Where is Atlantida?", LocalDateTime.now());

        //Add new user and his query list
        addNewUserAndQueryList(userQueries, userTest, sergeyList);
        //Add new query to existing user
        addNewQueryToList(userQueries, userTest, queryTest);
        //Get all USER queries sorted by timestamp
        printUserQueriesByTime(userQueries, userTest);
        //Remove User
        removeUserAndQueryList(userQueries, userTest);
    }

    public static void addNewUserAndQueryList(Map<User, List<Query>> userQueries, User user, List<Query> list) {
        userQueries.computeIfAbsent(user, key -> new ArrayList<>()).addAll(list);
        System.out.println("New user " + user.getName() + " and his query list was added");
        System.out.println();
    }

    public static void addNewQueryToList(Map<User, List<Query>> userQueries, User user, Query query) {
        userQueries.get(user).add(query);
        System.out.println(user.getName() + " added new query " + query.getContent());
        System.out.println();
    }

    public static void removeUserAndQueryList(Map<User, List<Query>> userQueries, User user) {
        userQueries.remove(user);
        System.out.println(user.getName() + " was removed!");
        System.out.println();
    }

    public static void printUserQueriesByTime(Map<User, List<Query>> userQueries, User user) {
        for (Map.Entry<User, List<Query>> entry : userQueries.entrySet()) {
            if (user.equals(entry.getKey())) {
                System.out.println(entry.getKey().getName() + " has following queries :");
                for (Query query : entry.getValue()) {
                    System.out.println(query.getContent() + " made at " +
                            query.getTimeStamp().format(FORMATTER));
                }
            }
        }
        System.out.println();
    }
}
