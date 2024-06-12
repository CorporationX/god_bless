package faang.school.godbless.elk_indexing;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private final Map<User, List<Query>> queryMap = new HashMap<>();

    //    Adds user to query map
    public void spyOnUser(User user, List<Query> queries) {
        if (queryMap.containsKey(user)) {
            throw new IllegalArgumentException("User already being spied on");
        }
        queryMap.put(user, queries);
    }

    public void updateUser(User user, Query query) {
        if (!queryMap.containsKey(user) && queryMap.get(user).contains(query)) {
            throw new IllegalArgumentException("User is not spied on, or query already exists");
        } else {
            System.out.println(queryMap.get(user));
            queryMap.get(user).add(query);
        }
    }

//    remove user from map :(
    public void boringCorpotateUserDelete(User user) {
        if(!queryMap.containsKey(user)) {
            throw new IllegalArgumentException("User is not spied on, hes scammer and cant sue you, sue him!");
        }
        queryMap.remove(user);
    }

//    print map
    public void report() {
        System.out.println(queryMap);
    }

//    5th point of task that prints sorted history
    public void actEvilAndSeeUsersSearchHistory() {
        for (Map.Entry<User, List<Query>> entry : queryMap.entrySet()) {
            System.out.println("*********" + entry.getKey() + "*********");
            Collections.sort(entry.getValue());
            for (Query query : entry.getValue()) {
                System.out.println(query);
            }
        }
    }

    Map<User, List<Query>> getQueryMap() {
        return queryMap;
    }
}
