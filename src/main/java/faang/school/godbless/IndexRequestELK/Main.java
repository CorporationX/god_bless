package faang.school.godbless.IndexRequestELK;

import java.util.*;

public class Main {

    private static final Map<User, List<Query>> USER_QUERIES = new HashMap<>();

    public static void main(String[] args) {
        User tempUser = new User("Nagibator228");

        USER_QUERIES.put(tempUser, new ArrayList<Query>());
        USER_QUERIES.get(tempUser).add(new Query(Calendar.getInstance(), "pudge guide"));
        Calendar tempCalendar = Calendar.getInstance();
        tempCalendar.set(Calendar.DAY_OF_MONTH, 5);
        USER_QUERIES.get(tempUser).add(new Query(tempCalendar, "invoker guide"));
        tempCalendar = Calendar.getInstance();
        tempCalendar.set(Calendar.DAY_OF_MONTH, 2);
        USER_QUERIES.get(tempUser).add(new Query(tempCalendar, "among us guide"));

        tempUser = new User("hjxa");
        List<Query> tempQueryList = new ArrayList<>();

        tempCalendar = Calendar.getInstance();
        tempCalendar.set(Calendar.DAY_OF_MONTH, 5);
        tempQueryList.add(new Query(tempCalendar, "dota"));

        tempCalendar = Calendar.getInstance();
        tempCalendar.set(Calendar.DAY_OF_MONTH, 7);
        tempQueryList.add(new Query(tempCalendar, "commandos"));

        addUserWithQuery(tempUser, tempQueryList);

        printQueriesSortedByTime();

        removeUserWithQuery(new User("Nagibator228", 1));

        printQueries();
    }

    public static void printQueries()
    {
        for (Map.Entry<User, List<Query>> entry : USER_QUERIES.entrySet())
        {
            System.out.println(entry.getKey().toString());
            entry.getValue().forEach( query -> {
                System.out.println(query.toString());
            });
            System.out.println("__________________________");
        }
    }

    public static void printQueriesSortedByTime()
    {
        for (Map.Entry<User, List<Query>> entry : USER_QUERIES.entrySet())
        {
            System.out.println(entry.getKey().toString());
            entry.getValue().sort( (firstQuery, secondQuery) ->
            {
                return firstQuery.getTimestamp().before(secondQuery.getTimestamp()) ? 1 : -1;
            });
            entry.getValue().forEach( query -> {
                System.out.println(query.toString());
            });
            System.out.println("________________________________________");
        }
    }

    public static void addUserWithQuery(User user, List<Query> queries)
    {
        USER_QUERIES.put(user, queries);
    }

    public static void removeUserWithQuery(User user)
    {
        USER_QUERIES.remove(user);
    }
}
