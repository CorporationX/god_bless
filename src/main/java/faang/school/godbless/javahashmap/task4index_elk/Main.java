package faang.school.godbless.javahashmap.task4index_elk;

import java.util.*;

public class Main {
    private static Map<User, List<Query>> mapQueries = new HashMap<>();

    public static void main(String... args) {
        User oleg = new User("Oleg");
        User alice = new User("Alice");
        User bob = new User("Bob");
        User notFounded = new User("rfgdg");

        List<Query> olegQueries = new ArrayList<>(List.of(new Query("Котики")));
        List<Query> aliceQueries = new ArrayList<>(List.of(new Query("Собачки")));
        List<Query> bobQueries = new ArrayList<>(List.of(new Query("Тутор по Hash map")));


        addMapQueries(oleg , olegQueries);
        addMapQueries(alice, aliceQueries);
        addMapQueries(bob, bobQueries);

        addUserQuery(notFounded, new Query("Купить газель"));
        addUserQuery(oleg, new Query("Жесткий фонк"));

        removeUser(notFounded);
        removeUser(bob);

        infoUser(notFounded);
        infoUser(oleg);

        info();

    }

    public static void addMapQueries(User user, List<Query> queries) {
        mapQueries.put(user, queries);

        System.out.println("Добавлен новый пользователь " + user.getName() + " со своим списком запросов\n" );
    }

    public static void addUserQuery(User user, Query query) {
        if (mapQueries.containsKey(user)) {
            mapQueries.get(user).add(query);
            System.out.println("Пользователю " + user.getName() + " добавлен новый запрос: \"" + query.getContent() + "\"\n");
        } else {
            System.out.println("Не был найден пользователь с именем " + user.getName() + "\n");
        }
    }

    public static void removeUser(User user) {
        if (mapQueries.containsKey(user)) {
            mapQueries.remove(user);
            System.out.println("Был удален пользователь " + user.getName() + "\n");
        } else {
            System.out.println("Не был найден пользователь с именем " + user.getName() + "\n");
        }
    }

    public static void info(){
        System.out.println("// info ------------------------------------------------------------------------");

        for (User user: mapQueries.keySet()) {
            System.out.println("Пользователь номер " + user.getId() + ": " + user.getName());
            System.out.print("Запросы: ");

            for (Query query: mapQueries.get(user)) {
                System.out.print("\"" + query.getContent() + "\" ");
            }

            System.out.println("");
        }

        System.out.println("------------------------------------------------------------------------\n");
    }

    public static void infoUser(User user) {
        if (!mapQueries.containsKey(user)) {
            System.out.println("Не был найден пользователь с именем " + user.getName() + "\n");
            return;
        }

        List<Query> queries = mapQueries.get(user);
        int count = 0;

        if (queries != null) {
            queries.sort((query1, query2) -> query1.getTimestamp().compareTo(query2.getTimestamp()));
            System.out.println("История запросов пользователя " + user.getName() + ":");

            for (Query query : queries) {
                count++;
                System.out.println("  Запрос " + count + ".  \"" + query.getContent() + "\" Время создания: " + query.getTimestamp());
            }
            System.out.println("");
        } else {
            System.out.println("У пользователя " + user.getName() + " еще нет запросов\n");
        }
    }

}
