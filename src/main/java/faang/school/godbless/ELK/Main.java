package faang.school.godbless.ELK;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class Main {
    public Main() {
        this.queriesByUser = new HashMap<>();
    }
    private Map<User, List<Query>> queriesByUser;

    public void addUser(User user) {
        queriesByUser.put(user, new ArrayList<>());
    }

    public void addUserQuery(User user, Query query) {
        queriesByUser.get(user).add(query);
    }

    public void deleteUser(User user) {
        queriesByUser.remove(user);
    }

    public void getUsersInfo() {
        for (Map.Entry<User, List<Query>> entry : queriesByUser.entrySet()){
            System.out.println("User: " + entry.getKey());
            for (Query query : entry.getValue()){
                System.out.println(query);
            }
        }
    }

    public void getUsersInfo(User user) {
        Collections.sort(queriesByUser.get(user), new Comparator<Query>() {
            @Override
            public int compare(Query q1, Query q2) {
                return q1.getTimestamp().compareTo(q2.getTimestamp());
            }
        });
        System.out.println("User: " + user);
        System.out.println(queriesByUser.get(user));
    }

    public List<User> getAllUsers() {
        return new ArrayList<>(queriesByUser.keySet());
    }
}
