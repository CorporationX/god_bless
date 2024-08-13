package faang.school.godbless.queryIndex;

import lombok.Getter;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class Main {
    private Map<User, List<Query>> listOfUserQueries;

    public Main() {
        this.listOfUserQueries = new HashMap<>();
    }


    public void addNewUserWithQueries(User user, List<Query> queries) {
        sortQueriesList(queries);
        listOfUserQueries.put(user, queries);
    }

    public static void sortQueriesList(List<Query> queries) {
        queries.sort(Comparator.comparing(Query::getTIMESTAMP));
    }

    public void addNewQuery(User user, Query query) {
        if (listOfUserQueries.containsKey(user)) {
            listOfUserQueries.get(user).add(query);
            sortQueriesList(listOfUserQueries.get(user));
        } else {
            throw new IllegalArgumentException("Такого пользователя в списке не найдено");
        }
    }

    public void removeUser(User user) {
        listOfUserQueries.remove(user);
    }

    public String allUsersWithQueries() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<User, List<Query>> entry : listOfUserQueries.entrySet()) {
            stringBuilder.append(userQueries(entry.getKey()));
        }
        return stringBuilder.toString();
    }

    public String userQueries(User user) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(user).append(":").append(System.lineSeparator());
        for (Query query : listOfUserQueries.get(user)) {
            stringBuilder.append("-").append(query).append(System.lineSeparator());
        }
        System.out.println(stringBuilder);
        return stringBuilder.toString();
    }
}
