package faang.school.godbless.BJS2_19748;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class Main {
    HashMap<User, List<Query>> userQueries = new HashMap<>();

    public void addUserWithQueries(User user, List<Query> queries) {
        userQueries.put(user,queries);
    }

    public void addQueryToUser(User user, Query query) {
        userQueries.get(user).add(query);
    }

    public void removeUserWithQueries(User user) {
        userQueries.remove(user);
    }

    public void printAllUsersAndQueries() {
        for(var entry : userQueries.entrySet()) {
            System.out.println(entry.getKey());
            for(var query : entry.getValue()) {
                System.out.println(query);
            }
        }
    }

    public void printUserQueries(User user) {
        for (var entry : userQueries.entrySet()) {
            if(entry.getKey().equals(user)) {
                System.out.println(entry.getKey());
                List<Query> temp = entry.getValue();
                temp.sort((Comparator.comparing(Query::getTimestamp)));
                for (var query : temp) {
                    System.out.println(query);
                }
            }
        }
    }
}
