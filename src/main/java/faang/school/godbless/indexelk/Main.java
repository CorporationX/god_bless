package faang.school.godbless.indexelk;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        QueryService queryService = new QueryService();
        Map<User, List<Query>> queryUserMap = new HashMap<>();

        User ivan = new User(1, "Ivan");
        queryService.addUser(queryUserMap, ivan, List.of(
                new Query(1, "Java", LocalDateTime.of(2020, 4, 1, 1, 1)),
                new Query(2, "Python", LocalDateTime.of(2021, 5, 1, 1, 1)),
                new Query(3, "Scala", LocalDateTime.of(2019, 6, 1, 1, 1)))
        );

        User petr = new User(2, "Petr");
        queryService.addQuery(queryUserMap, petr, new Query(1, "Java", LocalDateTime.of(2024, 4, 1, 1, 1)));
        queryService.addQuery(queryUserMap, petr, new Query(2, "Python", LocalDateTime.of(2022, 5, 1, 1, 1)));
        queryService.addQuery(queryUserMap, petr, new Query(3, "Scala", LocalDateTime.of(2018, 6, 1, 1, 1)));

        queryService.showUsersQueriesInfo(queryUserMap);
        System.out.println();

        queryService.showUserQueriesHistory(queryUserMap, ivan);
        System.out.println();

        queryService.showUserQueriesHistory(queryUserMap, petr);
        System.out.println();

        queryService.removeUser(queryUserMap, ivan);

        queryService.showUsersQueriesInfo(queryUserMap);
        System.out.println();

        try {
            queryService.removeUser(queryUserMap, ivan);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println();
        }

        try {
            queryService.showUserQueriesHistory(queryUserMap, ivan);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println();
        }
    }
}
