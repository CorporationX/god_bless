package faang.school.godbless.index;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final Map<User, List<Query>> USER_QUERIES = new HashMap<>();

    public static void main(String[] args) {
        User userOne = new User(1, "Vasya");
        User userTwo = new User(2, "Vova");
        List<Query> userOneQueries = new ArrayList<>();
        List<Query> userTwoQueries = new ArrayList<>();
        Query first = new Query(1,"SELECT * FROM table");
        Query second = new Query(2,"UPDATE table SET column1=value1 WHERE condition");
        Query third = new Query(3," DELETE * FROM table");
        userOneQueries.add(first);
        userTwoQueries.add(first);
        userOneQueries.add(second);
        userTwoQueries.add(second);
        addUser(userOne, userOneQueries);
        addUser(userTwo, userTwoQueries);
        addQuery(userOne,third);
        removeUser(userTwo);
        printAllUsers();
    }


    public static void addUser(User user, List<Query> queries) {
        USER_QUERIES.put(user, queries);
    }

    public static void addQuery(User user, Query query) {
        USER_QUERIES.computeIfAbsent(user, k -> new ArrayList<>()).add(query);
        // previous version
//        if (USER_QUERIES.containsKey(user)) {
//            USER_QUERIES.get(user).add(query);
//        } else {
//            USER_QUERIES.put(user, new ArrayList<>());
//            USER_QUERIES.get(user).add(query);
//        }
    }

    public static void removeUser(User user) {
        USER_QUERIES.remove(user);
    }

    public static void printAllUsers(){
        for(Map.Entry<User,List<Query>> entry : USER_QUERIES.entrySet()){
            User user =entry.getKey();
            List<Query> queries = entry.getValue();
            System.out.println(user + ":");
            for(Query query: queries){
                System.out.println(query + "");
            }
            System.out.println();
        }
    }
}
