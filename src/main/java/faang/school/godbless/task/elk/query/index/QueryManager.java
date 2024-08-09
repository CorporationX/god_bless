package faang.school.godbless.task.elk.query.index;

import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
public class QueryManager {
    private final Map<User, List<Query>> userAndQueryListMap;

    public void addNewUserWithQueryList(User user, List<Query> queries) {
        userValidOrNullPointerExceptionThrow(user);
        queriesListValidOrNullPointerExceptionThrow(queries);
        userAndQueryListMap.put(user, queries);
    }

    public void addNewQueryToExistingUser(User user, Query query) {
        userValidOrNullPointerExceptionThrow(user);
        queryValidOrNullPointerExceptionThrow(query);
        if (!userAndQueryListMap.containsKey(user)) {
            userNotFoundExceptionThrow(user);
        }
        userAndQueryListMap.computeIfAbsent(user, k ->
                new ArrayList<>()).add(query);
    }

    public void deleteUser(User user) {
        userValidOrNullPointerExceptionThrow(user);
        if (!userAndQueryListMap.containsKey(user)) {
            userNotFoundExceptionThrow(user);
        }
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

    public void printAllQueriesByUser(User user) {
        userValidOrNullPointerExceptionThrow(user);
        if (!userAndQueryListMap.containsKey(user)) {
            userNotFoundExceptionThrow(user);
        }
        List<Query> queries = userAndQueryListMap.get(user);
        queries.sort(Comparator.comparing(Query::getTimeStamp));
        printUserAndQueries(user, queries);
    }

    private void printUserAndQueries(User user, List<Query> queries) {
        System.out.println("Пользователь: " + user +
                "\nСписок запросов: ");
        queries.forEach(query -> {
            System.out.println(query);
        });
    }

    private void userValidOrNullPointerExceptionThrow(User user) {
        if (user == null) {
            throw new NullPointerException("Пользователь не может быть null");
        }
    }

    private void queryValidOrNullPointerExceptionThrow(Query query) {
        if (query == null) {
            throw new NullPointerException("Запрос не может быть null");
        }
    }

    private void queriesListValidOrNullPointerExceptionThrow(List<Query> queries) {
        if (queries == null) {
            throw new NullPointerException("Список запросов не может быть null");
        }
    }

    private void userNotFoundExceptionThrow(User user) throws NoSuchElementException {
        throw new NoSuchElementException("Пользователь %s не найден".formatted(user));
    }
}
