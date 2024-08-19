package faang.school.godbless.requestsELK;


import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;


@Getter
@Setter
public class Main {
    private Map<User, List<Query>> usersQueries = new HashMap<>();


    public static void main(String[] args) {
        Main main = new Main();

        User user1 = new User(1, "Alice");
        User user2 = new User(2, "Bob");

        Query query1 = new Query(1, "First query content");
        Query query2 = new Query(2, "Second query content");
        Query query3 = new Query(3, "Third query content");

        main.addUserWithListQueries(user1, Arrays.asList(query1, query2));
        main.addUserWithListQueries(user2, Arrays.asList(query3));

        main.addQueryForUser(user1, new Query(4, "Fourth query content"));
        System.out.println("All users and their queries:");
        main.allUsersAndQueries();

        main.removeUser(user2);
        System.out.println("All users and their queries after removing Bob:");
        main.allUsersAndQueries();
    }
    public void addUserWithListQueries(@NonNull User user, @NonNull List<Query> queries) {
        usersQueries.computeIfAbsent(user, key -> new ArrayList<>()).addAll(queries);
    }

    public void addQueryForUser(@NonNull User user, @NonNull Query query) {
        usersQueries.computeIfAbsent(user, key -> new ArrayList<>()).add(query);
    }

    public void removeUser(@NonNull User user) {
        usersQueries.remove(user);
    }

    public void allUsersAndQueries() {
        for (Map.Entry<User, List<Query>> entry : usersQueries.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue() + "\n");
        }
    }


}
