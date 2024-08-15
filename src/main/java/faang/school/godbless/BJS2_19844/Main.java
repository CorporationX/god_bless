package faang.school.godbless.BJS2_19844;

import java.util.*;

public class Main {

    private static Map<User, List<Query>> requests = new HashMap<>();

    public static void addUser(User user){
        requests.computeIfAbsent(user, value -> new ArrayList<>());
    }

    public static void addQuery(User user, Query query){
        if (!requests.containsKey(user)) {
            System.out.println("User not found!");
            return;
        }
        requests.get(user).add(query);
    }

    public static void deleteUser(User user){
        requests.remove(user);
    }

    public static void printAllUsers(Map<User, List<Query>> allUsers){
        allUsers.forEach((key, value) -> System.out.println(key + " " + value));
    }

    public static void printAllQuery(User user){
        List<Query> queries = requests.get(user).stream().sorted(Comparator.comparing(Query::getTimestamp)).toList();
        System.out.println("User: " + user.getName());
        for (Query query : queries){
            System.out.println("Query - " + query.getContent() + query.getTimestamp());
        }
    }

    public static void main(String[] args) throws InterruptedException {

        User user = new User(1, "Ruslan");
        Query query = new Query(1, "Programming");
        Query query1 = new Query(2, "Snowboarding");
        Query query2 = new Query(3, "Flexing");

        User user1 = new User(2, "Darina");
        Query query3 = new Query(1, "Java EE");
        Query query4 = new Query(2, "Sql");
        Query query5 = new Query(3, "Java Script");

        addUser(user);
        addQuery(user,query);
        Thread.sleep(1000);
        addQuery(user,query2);
        Thread.sleep(1000);

        addUser(user1);
        addQuery(user1,query3);
        Thread.sleep(1000);
        addQuery(user1,query4);
        Thread.sleep(1000);
        addQuery(user1,query5);
        Thread.sleep(1000);

        addQuery(user,query1);
        Thread.sleep(1000);

        printAllUsers(requests);
        deleteUser(user1);
        printAllQuery(user);
    }

}
