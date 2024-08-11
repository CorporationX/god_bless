package faang.school.godbless.BJS2_19885;

import java.time.LocalDateTime;
import java.util.Comparator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static Map<User, List<Query>> queriesByUser = new HashMap<>();

    public static void main(String[] args) {
        User userArtem = new User(1, "Артем");
        User userMaxim = new User(2, "Иван");

        User.addUser(userArtem);
        User.addUser(userMaxim);

        Query.addQueryForUser(userArtem, new Query(1, "Чтение java документации", LocalDateTime.now().minusHours(2)));
        Query.addQueryForUser(userArtem, new Query(2, "Заказ пиццы", LocalDateTime.now().minusHours(1)));

        Query.addQueryForUser(userMaxim, new Query(3, "Запрос на PR (github)", LocalDateTime.now().minusHours(3)));
        Query.addQueryForUser(userMaxim, new Query(4, "Покупка клавиатуры", LocalDateTime.now().minusHours(2)));

        printAllUsersAndQueries();
        printUserQueryHistory(userArtem);

        User.removeUser(userArtem);

        printAllUsersAndQueries();
    }

    public static void printAllUsersAndQueries() {
        for (Map.Entry<User, List<Query>> entry : queriesByUser.entrySet()) {
            for (Query query : entry.getValue()) {
                System.out.println("  Запрос: " + query.getContent() + " Время: " + query.getTimestamp());
            }
        }
    }

    public static void printUserQueryHistory(User user) {
        List<Query> queries = queriesByUser.get(user);
        if (queries != null) {
            queries.sort(Comparator.comparing(Query::getTimestamp));
            for (Query query : queries) {
                System.out.println("  " + query.getContent() + " Время: " + query.getTimestamp());
            }
        } else {
            System.out.println("Пользователь не найден.");
        }
    }
}
