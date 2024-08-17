package faang.school.godbless.task.hashmap.elk.query.index;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
public class QueryManager {
    private final Map<User, List<Query>> userAndQueryListMap;

    public void addNewUserWithQueryList(@NonNull User user, List<Query> queries) {
        userAndQueryListMap.put(user, queries);
    }

    public void addNewQueryToExistingUser(@NonNull User user, Query query) {
        if (!userAndQueryListMap.containsKey(user)) {
            throw new NoSuchElementException("Пользователь %s не найден".formatted(user));
        }
        List<Query> queries = userAndQueryListMap.get(user);
        queries.add(query);
        queries.sort(Comparator.comparing(Query::getTimeStamp));
    }

    public void deleteUser(@NonNull User user) {
        userAndQueryListMap.remove(user);
    }

    public void printAllUsersWithQueries() {
        if (userAndQueryListMap.isEmpty()) {
            System.out.println("Список пользователей и их запросов пуст");
        }
        userAndQueryListMap.entrySet().forEach(entry -> {
            printUserAndQueries(entry.getKey(), entry.getValue());
        });
    }

    public void printAllQueriesByUser(@NonNull User user) {
        if (!userAndQueryListMap.containsKey(user)) {
            throw new NoSuchElementException("Пользователь %s не найден".formatted(user));
        }
        userAndQueryListMap.entrySet().forEach(entry -> {
            printUserAndQueries(entry.getKey(), entry.getValue());
        });
    }

    private void printUserAndQueries(@NonNull User user, List<Query> queries) {
        System.out.println("Пользователь: " + user.getName() +
                "\nСписок запросов: ");
        queries.forEach(query -> {
            System.out.println(query);
        });
    }
}
