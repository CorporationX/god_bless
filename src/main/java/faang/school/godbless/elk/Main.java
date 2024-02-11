package faang.school.godbless.elk;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class Main {
    static Map<User, List<Query>> queriesByUser = new HashMap<>();

    public static void main(String[] args) {
        Query query = new Query(1, "Content1");
        Query query1 = new Query(2, "Content2");
        Query query2 = new Query(3, "Content3");
        Query query3 = new Query(4, "Content4");
        Query query4 = new Query(5, "Content5");
        Query query5 = new Query(6, "Content6");
        Query query6 = new Query(7, "Content7");
        Query query7 = new Query(8, "Content8");
        Query query8 = new Query(8, "Content9");
        User user = new User(1, "Kirill");
        List<Query> queries = new ArrayList<>();
        queries.add(query);
        queries.add(query6);
        queries.add(query2);
        queries.add(query8);
        queries.add(query4);
        queries.add(query5);
        queries.add(query3);
        queries.add(query1);

        addNewUser(user, queries);
        listAllUsersAndQueries();
        System.out.println();
        sequenceOfQueries(user);
        deleteUser(user);
        System.out.println("now");
        listAllUsersAndQueries();
        System.out.println("now");


    }

    public static void addNewUser(User user, List<Query> queries) {
        if (!queriesByUser.containsKey(user)) {
            queriesByUser.put(user, queries);
        }
    }

    public static void addQueriesForExistingUser(User user, List<Query> queries) {
        if (queriesByUser.containsKey(user)) {

            queriesByUser.get(user).addAll(queries);
        }
    }

    public static void deleteUser(User user) {
        queriesByUser.remove(user);
    }

    public static void listAllUsersAndQueries() {
        System.out.println(queriesByUser);
    }

    public static void sequenceOfQueries(User user) {
        TreeSet<Query> queries = new TreeSet<>(queriesByUser.get(user));
        System.out.println(user.getName() + " had following queries: " + "\n" + queries);
    }

}