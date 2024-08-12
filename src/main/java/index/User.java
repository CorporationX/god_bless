package index;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

@ToString
@EqualsAndHashCode
@Setter
@Getter
@AllArgsConstructor
public class User {
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

    public static void sortHistoryQuery(Map<User, List<Query>> testMap) {
        for (Map.Entry<User,List<Query>> pair : testMap.entrySet()) {
        }
    }

}
