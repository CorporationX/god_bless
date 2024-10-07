package school.faang.task1311;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserService {

    public static final HashMap<User, List<Query>> USERS_CONTENT = new HashMap<>();

    public static void addUser(User user, ArrayList<Query> query) {
        USERS_CONTENT.put(user, query);
    }

    public static void addQuery(User user, Query query) {
        USERS_CONTENT.get(user).add(query);
    }

    public static void removeUser(User user) {
        USERS_CONTENT.remove(user);
    }

    public static void printAll() {
        for (Map.Entry<User, List<Query>> entry : USERS_CONTENT.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    public static void printAllUserQuery(User user) {
        ArrayList<Query> listToPrint = (ArrayList<Query>) USERS_CONTENT.get(user);
        Collections.sort(listToPrint, ((o1, o2) -> o1.getTimestamp() - o2.getTimestamp()));

        for (Query query : listToPrint) {
            System.out.println(query);
        }
    }
}
