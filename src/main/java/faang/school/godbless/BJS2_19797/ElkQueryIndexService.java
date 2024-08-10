package faang.school.godbless.BJS2_19797;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ElkQueryIndexService {

    private Map<User, List<Query>> userQueries = new HashMap<>();
    private Map<User, List<Query>> userQueriesHistory = new HashMap<>();

    public void putUserWithQueries(User user, List<Query> queries) {
        if (!userQueries.containsKey(user)) {
            userQueriesHistory.put(user, queries);
        }
        userQueries.put(user, queries);
    }

    public boolean putUserForQuery(User user, Query query) {
        if (userQueries.containsKey(user)) {
            userQueries.get(user).add(query);
            if (!userQueriesHistory.containsKey(user)) {
                userQueriesHistory.get(user).add(query);
            }
            return true;
        } else {
            return false;
        }
    }

    public void removeUser(User user) {
        userQueries.remove(user);
    }

    public void printUserQueries() {
        for (Map.Entry<User, List<Query>> entry : userQueries.entrySet()) {
            User user = entry.getKey();
            List<Query> queries = entry.getValue();
            System.out.printf("%s = %s%n", user.getName(), queries);
        }
    }

    public void printUserQueriesHistoryWithSorting() {
        for (Map.Entry<User, List<Query>> entry : userQueriesHistory.entrySet()) {
            User user = entry.getKey();
            List<Query> queries = entry.getValue();
            sortByTimestamp(queries);
            System.out.printf("%s = %s%n", user.getName(), queries);
        }
    }

    private void sortByTimestamp(List<Query> queries) {
        Collections.sort(queries);
    }
}
