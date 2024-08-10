package faang.school.godbless.elk;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Index {
    private final Map<User, List<Query>> index = new HashMap<>();

    public void addUser(User user, List<Query> queries) {
        index.put(user, queries);
    }

    public boolean addQuery(User user, Query query) {
        if (index.containsKey(user)) {
            index.get(user).add(query);
            return true;
        }
        return false;
    }

    public boolean removeUser(User user) {
        if (index.containsKey(user)) {
            index.remove(user);
            return true;
        }
        return false;
    }

    public String indexReport() {
        StringBuilder report = new StringBuilder();
        for (var entry : index.entrySet()) {
            report.append(indexUserReport(entry.getKey()));
        }
        return report.toString();
    }

    public String indexUserReport(User user) throws IllegalArgumentException {
        if (!index.containsKey(user)){
            throw new IllegalArgumentException("no such user");
        }
        StringBuilder report = new StringBuilder();
        report.append(user.getName()).append(":\n");
        List<Query> list = index.get(user);
        List<Query> sortedList = list.stream().sorted(Comparator.comparingDouble(Query::getTimestamp)).
                toList();
        for (var query : sortedList) {
            report.append(query.getTimestamp()).append(":").append(query.getContent()).append("\n");
        }
        return report.toString();
    }


}
