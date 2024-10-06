package school.faang.elk.index;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private final Map<User, List<Query>> userToQueries = new HashMap<>();

    public static void main(String[] args) {
        Main main = new Main();
        User user1 = new User(1, "Коля");
        User user2 = new User(2, "Андрей");
        User user3 = new User(3, "Заур");

        Query query1 = new Query(1, "Hello world!", LocalDateTime.now());
        Query query2 = new Query(2, "Hello world!", LocalDateTime.now());
        Query query3 = new Query(3, "Hello world!", LocalDateTime.now());
        Query query4 = new Query(4, "Hello world!", LocalDateTime.now());
        Query query5 = new Query(5, "Hello world!", LocalDateTime.now());
        Query query6 = new Query(6, "Hello world!", LocalDateTime.now());
        Query query7 = new Query(7, "Hello world!", LocalDateTime.now());

        main.addUser(user1, new ArrayList<>(List.of(query1, query2)));
        main.addUser(user2, new ArrayList<>(List.of(query3, query4)));
        main.addUser(user3, new ArrayList<>(List.of(query5, query6)));
        main.print();
        System.out.println();

        main.addQueryToUser(user3, query7);
        main.print();
        System.out.println();

        main.removeUser(user1);
        main.print();
        System.out.println();
    }

    public void addUser(User user, List<Query> queries) {
        userToQueries.put(user, queries);
    }

    public void addQueryToUser(User user, Query query) {
        List<Query> queries = userToQueries.getOrDefault(user, new ArrayList<>());
        queries.add(query);
        userToQueries.put(user, queries);
    }

    public void removeUser(User user) {
        userToQueries.remove(user);
    }

    public void print() {
        userToQueries.forEach((user, queries) -> System.out.println(user + ": " + queries));
    }
}
