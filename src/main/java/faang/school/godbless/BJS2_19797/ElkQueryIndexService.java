package faang.school.godbless.BJS2_19797;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ElkQueryIndexService {

    private Map<User, List<Query>> userQueries;
    private Map<User, List<Query>> userQueriesHistory;

    public ElkQueryIndexService() {
        this.userQueries = new HashMap<>();
        this.userQueriesHistory = new HashMap<>();
    }

    public void put(User user, List<Query> queries) {
        if (!userQueries.containsKey(user)) {
            userQueriesHistory.put(user, queries);
        }
        userQueries.put(user, queries);
    }

    public boolean put(User user, Query query) {
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

    public void remove(User user) {
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
        queries.sort(Comparator.comparing(Query::getDate, Comparator.naturalOrder()));
    }
}
