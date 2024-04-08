package elk;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    private static Map<User, List<Query>> userQueries = new HashMap<>();

    public static void main(String[] args) {
        User user1 = new User(1, "Ivan");
        List<Query> queryList1 = new ArrayList<>();
        queryList1.add(new Query(1, "Java", "20240502"));
        queryList1.add(new Query(2, "Python", "2023057"));
        queryList1.add(new Query(3, "Scala", "20221204"));
        addUserWithQueries(user1, queryList1);

        User user2 = new User(2, "Nikita");
        List<Query> queryList2 = new ArrayList<>();
        queryList2.add(new Query(1, "Java", "19990324"));
        queryList2.add(new Query(2, "Python", "20100825"));
        queryList2.add(new Query(3, "Scala", "20150623"));
        addUserWithQueries(user2, queryList2);

        printAllUserAndQueries();

        printHistoryOfQueriesForEachUser();

        addNewQueryToUser(user1, new Query(4, "Python", "20180807"));

        printHistoryOfQueriesForEachUser();

        removeUser(user1);

        printHistoryOfQueriesForEachUser();
    }

    private static void addUserWithQueries(User user, List<Query> queries){
        if(user == null){
            System.out.println("User is null");
            return;
        }
        userQueries.put(user, queries);
    }

    private static void addNewQueryToUser(User user, Query query){
        if(user == null){
            System.out.println("User is null");
            return;
        }
        userQueries.computeIfAbsent(user, key -> new ArrayList<>()).add(query);
    }

    private static void removeUser(User user){
        if(user == null){
            System.out.println("User is null");
            return;
        }
        userQueries.remove(user);
    }

    private static void printAllUserAndQueries(){
        for(Map.Entry<User, List<Query>> entry: userQueries.entrySet()){
            System.out.println(entry.getKey() + ": ");
            entry.getValue().forEach(System.out::println);
        }
        System.out.println();
    }

    private static void printHistoryOfQueriesForEachUser(){
        for(Map.Entry<User, List<Query>> entry: userQueries.entrySet()){
            System.out.println(entry.getKey() + ": ");
            Comparator<Query> comparator = (o1, o2) -> o2.getTimestamp().compareTo(o1.getTimestamp());
            Collections.sort(entry.getValue(), comparator);
            entry.getValue().forEach(System.out::println);
        }
        System.out.println();
    }
}

