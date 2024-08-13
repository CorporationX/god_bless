package faang.school.godbless.java.sql.elk;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@Getter
public class ElkService {

    private final Map<User, List<Query>> userQueriesMap = new HashMap<>();


    public void addNewUserWithQueries(User user, List<Query> queries) {
        this.userQueriesMap.put(user, queries);
    }

    public void addNewQueryToExistingUser(User user, Query query) {
        List<Query> queries = userQueriesMap.get(user);
        if (queries == null) {
            throw new NoSuchElementException(Constants.USER_NOT_FOUND);
        }
        queries.add(query);
    }


    public void deleteUser(User user) {
        List<Query> queries = this.userQueriesMap.remove(user);
        if (queries == null) {
            throw new NoSuchElementException(Constants.USER_NOT_FOUND);
        }
    }

    public void showUsersQueries() {
        if (this.userQueriesMap.isEmpty()) {
            System.out.println(Constants.USER_NOT_FOUND);
            return;
        }

        this.userQueriesMap.forEach((key, value) -> {
            System.out.printf("%nUser %s made the following queries:%n", key.getName());
            value.forEach(query -> {
                System.out.printf("%s, %n", query.getContent());
            });
        });

    }

    public void showUserQueryHistory(User user) {
        List<Query> queries = userQueriesMap.get(user);
        if (queries == null) {
            throw new NoSuchElementException(Constants.USER_NOT_FOUND);
        }
        queries.sort(Comparator.comparing(Query::getTimestamp));
        System.out.printf("%nUser %s made the following queries:%n", user.getName());
        for (Query query: queries) {
            System.out.printf("%s, %s %n", query.getContent(), query.getTimestamp());
        }
    }

}
