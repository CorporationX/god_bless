package faang.school.godbless.bjs2_19737;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private Map<User, List<Query>> userQueries = new HashMap<>();

    public void addUserWithQueries(User user, List<Query> queries) {
        queries.sort(Comparator.comparing(Query::getTimestamp).reversed());
        userQueries.put(user, queries);
    }

    public void addQueryToUser(Query query, User user) {
        var existedQueries = userQueries.get(user);
        if (existedQueries != null) {
            existedQueries.add(query);
            int last = existedQueries.size() - 1;
            for (int i = 0; i < last; i++) {
                var right = existedQueries.get(last - i);
                var left = existedQueries.get(last - i - 1);
                var rightTimestamp = right.getTimestamp();
                var leftTimestamp = left.getTimestamp();
                if (rightTimestamp.isAfter(leftTimestamp)) {
                    var temp = right;
                    existedQueries.set(last - i, left);
                    existedQueries.set(last - i - 1, temp);
                } else {
                    break;
                }
            }
        }
    }

    public void removeUser(User user) {
        userQueries.remove(user);
    }

    public void printAllUsers() {
        userQueries.forEach((user, queries) -> {
            System.out.println("User: " + user.getName());
            printQueries(queries);
        });
    }

    public void printQueries(List<Query> queries) {
        queries.forEach(query -> System.out.println("    " + query.toString()));
    }

    public void printUserWithSortedQueries(User user) {
        for (Map.Entry<User, List<Query>> entry : userQueries.entrySet()) {
            var u = entry.getKey();
            if (u.equals(user)) {
                System.out.println("User: " + u.getName());
                printQueries(entry.getValue());
            }
        }
    }

    // for tests
    public Map<User, List<Query>> getUserQueries() {
        return userQueries;
    }
}
