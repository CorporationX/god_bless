package faang.school.godbless.inedxELK;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    private static Map<User, List<Query>> usersQueries;
    public static void main(String[] args) {
        usersQueries = new HashMap<>(Map.of(
                new User(1, "1"), new ArrayList<>(Arrays.asList(
                        new Query(1, "xxx", 311),
                        new Query(2, "Sygf", 222)
                )),
                new User(2, "2"), new ArrayList<>(Arrays.asList(
                        new Query(3, "xxxtentacion", 4),
                        new Query(4, "ComedyClub", 2)
                ))
        ));

        addUser(new User(3, "3"), new ArrayList<>(
                Arrays.asList(
                        new Query(5, "dota2", 110),
                        new Query(6, "how to return an...", 5)
                )
        ));

        addQuery(new Query(7, "free sneakers", 98), new User(3, "3"));

        deleteUser(new User(1, "1"));

        print();
    }

    private static void addUser(User user, List<Query> queries) {
        usersQueries.put(user, queries);
    }

    private static void addQuery(Query query, User user) {
        usersQueries.computeIfAbsent(user, k -> new ArrayList<>()).add(query);
    }

    private static void deleteUser(User user){
        usersQueries.remove(user);
    }

    private static void print(){
        for (Map.Entry<User, List<Query>> pair: usersQueries.entrySet()){
            System.out.println("* " + pair.getKey().toString() + " :");
            pair.getValue().sort((Query q1, Query q2) -> Math.toIntExact(q1.getTimestamp() - q2.getTimestamp()));
            for (Query query: pair.getValue()) {
                System.out.println("\t" + query.toString());
            }
            System.out.print("\n\n");
        }
    }
}
