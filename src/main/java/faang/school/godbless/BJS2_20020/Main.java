package faang.school.godbless.BJS2_20020;

import lombok.Data;

import java.util.*;

@Data
public class Main {
    private Map<User, List<Query>> userQueries;

    public Main() {
        this.userQueries = new HashMap<>();
    }
    public void addUser(User user) {
        userQueries.putIfAbsent(user, new ArrayList<>());
    }
    public void addQuery(User user, Query query) {
        userQueries.computeIfAbsent(user, k -> new ArrayList<>()).add(query);
    }
    public void removeUserWithQuery(User user) {
        userQueries.remove(user);
    }
    public void getAllUsersWithQuery() {
        for(Map.Entry<User, List<Query>> userListEntry : userQueries.entrySet()) {
            System.out.println("Пользователь: " + userListEntry.getKey());
            for(Query query : userListEntry.getValue()) {
                System.out.println("Запрос(ы): " + query);
            }
        }
    }
    public void historyQuerySortedByTimeStamp(User user) {
        for(Map.Entry<User, List<Query>> userListEntry : userQueries.entrySet()) {
            if(userListEntry.getKey().equals(user)) {
                List<Query> queries = userListEntry.getValue();
                queries.sort(Comparator.comparing(Query::getTimestamp));
                System.out.println("Юзер с id = " + user.getId() + " и именем - " + user.getName());
                for (Query query : queries) {
                    System.out.println("Запрос(ы): " + query);
                }
                return;
            }
        }
    }
}
