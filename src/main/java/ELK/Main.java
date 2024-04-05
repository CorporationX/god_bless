package ELK;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    private static Map<User, List<Query>> userListMap = new HashMap<>();
    public static void main(String[] args) {
        User user1 = new User(1, "Ivan");
        List<Query> queryList1 = new ArrayList<>();
        queryList1.add(new Query(1, "Java", "20240502"));
        queryList1.add(new Query(2, "Python", "2023057"));
        queryList1.add(new Query(3, "Scala", "20221204"));
        addQueryOfUser(user1, queryList1);

        User user2 = new User(2, "Nikita");
        List<Query> queryList2 = new ArrayList<>();
        queryList2.add(new Query(1, "Java", "19990324"));
        queryList2.add(new Query(2, "Python", "20100825"));
        queryList2.add(new Query(3, "Scala", "20150623"));
        addQueryOfUser(user2, queryList2);

        printAllUserAndQueries();

        printHistoryOfQueriesForEachUser();

        addNewQueryToUser(user1, new Query(4, "Python", "20180807"));

        printHistoryOfQueriesForEachUser();

        removeUser(user1);

        printHistoryOfQueriesForEachUser();
    }
    public static void addQueryOfUser(User user, List<Query> list){
        userListMap.put(user, list);
    }

    public static void addNewQueryToUser(User user, Query query){
        userListMap.computeIfAbsent(user, key -> new ArrayList<>()).add(query);
    }

    public static void removeUser(User user){
        userListMap.remove(user);
    }

    public static void printAllUserAndQueries(){
        for(Map.Entry<User, List<Query>> entry: userListMap.entrySet()){
            System.out.println(entry.getKey() + ": ");
            entry.getValue().forEach(System.out::println);
        }
        System.out.println();
    }

    public static void printHistoryOfQueriesForEachUser(){
        for(Map.Entry<User, List<Query>> entry: userListMap.entrySet()){
            System.out.println(entry.getKey() + ": ");
            Comparator<Query> comparator = (o1, o2) -> o2.timestamp().compareTo(o1.timestamp());
            Collections.sort(entry.getValue(), comparator);
            entry.getValue().forEach(System.out::println);
        }
        System.out.println();
    }
}

