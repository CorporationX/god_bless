package faang.school.godbless.query_index;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Getter
@Setter
public class QueryManager {
    private Map<User, List<Query>> userQueryMap;

    public QueryManager() {
        this.userQueryMap = new HashMap<>();
    }

    public void addNewUserAndQueries(User user, List<Query> queries) {
        userQueryMap.put(user, new ArrayList<>(queries));
    }

    public void addQueriesToUser(User user, Query query) {
        userQueryMap.computeIfAbsent(user, userAsKey -> new ArrayList<>()).add(query);
    }

    public void deleteUserAndQueries(User user) {
        if (userQueryMap.containsKey(user)) {
            userQueryMap.remove(user);
        } else {
            log.warn("Could not find and delete user: {}", user);
        }
    }

    public void showUsersAndQueries() {
        for (Map.Entry<User, List<Query>> userQueryEntry : userQueryMap.entrySet()) {
            System.out.println("Queries of" + userQueryEntry.getKey().getName());
            for (Query query : userQueryEntry.getValue()) {
                System.out.println(query);
            }
        }
    }

    public void showUserHistory(User user) {
        if (!userQueryMap.containsKey(user)) {
            log.warn("Could not find user {}", user);
        } else {
            List<Query> queries = userQueryMap.get(user);
            Collections.sort(queries);
            for (Query query : queries) {
                System.out.println(query);
            }
        }
    }
}
