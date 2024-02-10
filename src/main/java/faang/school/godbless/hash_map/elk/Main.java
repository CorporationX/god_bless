package faang.school.godbless.hash_map.elk;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static Map<User, List<Query>> userIndexQuery = new HashMap<>();

    public static void main(String[] args) throws InterruptedException {
        User user = new User(1, "Kirill");
        User user1 = new User(2, "Arseniy");
        Query query = new Query(1, "Дом 2", System.currentTimeMillis());
        Thread.sleep(100);
        Query query1 = new Query(2, "Дом 3", System.currentTimeMillis());
        Thread.sleep(100);
        Query query2 = new Query(1, "Java учить", System.currentTimeMillis());

        add(user1, List.of(query1, query));

        printUser();
        deleteUserAndQuery(user);
        System.out.println("-------");
        printUser();
        System.out.println("-------------");
        System.out.println(userIndexQuery);

        userQuery(user1);

        userQuery(user);
        userQuery(null);
    }

    public static void add(User user, List<Query> listQuery){
        if(user != null && listQuery != null) {
            userIndexQuery.putIfAbsent(user, listQuery);
        }
    }

    public static void addQueryUser(User user, Query query){
        if(user != null && query != null) {
            var listQuery = userIndexQuery.get(user);
            if (userIndexQuery.containsKey(user) && !listQuery.contains(query)) {
                userIndexQuery.get(user).add(query);
            }
        }
    }

    public static void deleteUserAndQuery(User user){
        userIndexQuery.remove(user);
    }

    public static void printUser(){
        for(var entry: userIndexQuery.entrySet()){
            if(!(entry.getKey() == null || entry.getValue() == null)) {
                System.out.println("Имя: " + entry.getKey().getName());
                List<Query> listQueryUser = entry.getValue();
                for (Query query : listQueryUser){
                    System.out.println("Запросы: " + query.getContent() + " | Время создания: " + query.getTimestamp());
                }
                System.out.println("----------");
            }
        }
    }

    public static void userQuery(User user) {
        if (user != null) {
            System.out.println("User: " + user.getName());
            List<Query> userQueries = userIndexQuery.get(user);
            if (userQueries != null) {
                userQueries.stream().sorted().forEach(System.out::println);
            }
        }
    }
}
