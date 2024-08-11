package faang.school.godbless.ELK;

import lombok.Getter;

import java.util.*;

@Getter
public class Main {
    private Map<User, List<Query>> queriesByUser;

    public void addUser(User user) {
        queriesByUser.put(user, new ArrayList<Query>());
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
}
