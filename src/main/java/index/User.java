package index;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ToString
@EqualsAndHashCode
@Setter
@Getter
@AllArgsConstructor
public class User implements Comparator<Query> {
    private int id;
    private String name;

    public static void addUSer(Map<User, List<Query>> testMap, User user, List<Query> queries) {
      testMap.put(user, queries);
    }

    public static void newQuery(Map<User, List<Query>> testMap, User user, Query query) {
        testMap.get(user).add(query);
    }

    public static void removeUser(Map<User, List<Query>> testMap, User user) {
        testMap.remove(user);
    }

    public static void outputMap(Map<User, List<Query>> testMap) {
        for (Map.Entry<User,List<Query>> pair : testMap.entrySet()) {
            System.out.println(pair.getKey() + " : " + pair.getValue());
        }
    }

    public static void sortHistoryQuery(Map<User, List<Query>> queryByUser)  {

        for (Map.Entry<User, List<Query>> pair : queryByUser.entrySet()) {
            List sortedQueries = pair.getValue().stream()
                    .sorted(Comparator.comparingInt(Query::getTimestamp)) // скажу честно, взял у VladAI потому что сам не мог долгое время решить
                    .collect(Collectors.toList());

            System.out.println("Пользователь: " + pair.getKey() + ", Запросы: " + sortedQueries);
        }
    }

    @Override
    public int compare(Query o1, Query o2) {
        return Integer.compare(o1.getTimestamp(), o2.getTimestamp());
        }
}
