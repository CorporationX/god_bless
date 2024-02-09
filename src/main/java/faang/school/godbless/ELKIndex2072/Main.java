package faang.school.godbless.ELKIndex2072;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    static Map<User, List<Query>> usersQueryMap = new HashMap<>();

    public static void main(String[] args) throws InterruptedException {
        Query test1 = new Query("Учить java быстро", System.currentTimeMillis());
        Thread.sleep(10);
        Query test2 = new Query("Как не спать неделю", System.currentTimeMillis());
        Thread.sleep(10);
        Query test3 = new Query("Перестать плакать от количества задач", System.currentTimeMillis());
        Thread.sleep(10);
        Query test4 = new Query("Мотивацию надо подняяять видео", System.currentTimeMillis());
        Thread.sleep(10);
        Query test5 = new Query("Речь благодарности техлиду за ревью, без кринжа", System.currentTimeMillis());
        Thread.sleep(10);
        Query test6 = new Query("Купить носки онлайн", System.currentTimeMillis());
        User testUser1 = new User("Bedolaga1");
        User testUser2 = new User("Bedolaga2");
        User testUser3 = new User("Bedolaga3");
        addUserToMap(testUser1, new ArrayList<>());
        addUserToMap(testUser2, new ArrayList<>());
        addUserToMap(testUser3, new ArrayList<>());
        printAllUsersInfo();
        addQueryToUser(testUser1, test1);
        addQueryToUser(testUser1, test5);
        addQueryToUser(testUser1, test3);
        addQueryToUser(testUser2, test1);
        addQueryToUser(testUser2, test6);
        addQueryToUser(testUser2, test2);
        addQueryToUser(testUser3, test1);
        addQueryToUser(testUser3, test4);
        addQueryToUser(testUser3, test3);
        printAllUsersInfo();
        printUserQueryHistory();
    }

    public static void addUserToMap(User user, List<Query> list) {
        if (!usersQueryMap.containsKey(user)) {
            usersQueryMap.put(user, list);
        }
    }

    public static void addQueryToUser(User user, Query query) {
        if (!usersQueryMap.containsKey(user)) {
            usersQueryMap.put(user, new ArrayList<>());
        }
        usersQueryMap.get(user).add(query);
    }

    public static void removeUserFromMap(User user) {
        if (usersQueryMap.containsKey(user)) {
            usersQueryMap.remove(user);
        }
    }

    public static void printAllUsersInfo() {
        for (var entry : usersQueryMap.entrySet()) {
            System.out.println("USER: " + entry.getKey().getName());
            System.out.println("HIS QUERYS: ");
            for (int i = 0; i < entry.getValue().size(); i++) {
                System.out.println(entry.getValue().get(i).getContent());
            }
        }
    }

    public static void printUserQueryHistory() {
        for (var entry : usersQueryMap.entrySet()) {
            System.out.println("USER: " + entry.getKey().getName());
            entry.getValue().stream().sorted().forEach(query -> System.out.println(query));
        }
    }
}

