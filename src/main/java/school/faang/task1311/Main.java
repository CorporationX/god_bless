package school.faang.task1311;

import java.util.*;

public class Main {

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
        Collections.sort(listToPrint, new Comparator<Query>() {
            @Override
            public int compare(Query o1, Query o2) {
                return o1.getTimestamp() - o2.getTimestamp();
            }
        });

        for (Query query : listToPrint) {
            System.out.println(query);
        }
    }

    public static void main(String[] args) {
        User firstUser = new User(1, "Ilya");
        User secondUser = new User(2, "Artem");
        User thirdUser = new User(3, "Max");

        Query queryFirstUser = new Query(1, "Zoo", 3);
        Query queryFirstUser2 = new Query(2, "Facebook", 1);

        Query querySecondUser = new Query(3, "Twitch", 34);
        Query querySecondUser2 = new Query(4, "Youtube", 5);

        Query queryThirdUser = new Query(5, "Instagram", 13);
        Query queryThirdUser2 = new Query(6, "KFC", 7);

        ArrayList<Query> userOneList = new ArrayList<>();
        ArrayList<Query> userTwoList = new ArrayList<>();
        ArrayList<Query> userThreeList = new ArrayList<>();

        userOneList.add(queryFirstUser);
        userOneList.add(queryFirstUser2);

        userTwoList.add(querySecondUser);
        userTwoList.add(querySecondUser2);

        userThreeList.add(queryThirdUser);
        userThreeList.add(queryThirdUser2);

        addUser(firstUser, userOneList);
        addUser(secondUser, userTwoList);
        addUser(thirdUser, userThreeList);

        printAll();
        System.out.println();

        Query queryToAdd = new Query(7, "Habr", 10);
        addQuery(firstUser, queryToAdd);
        printAll();
        System.out.println();

        removeUser(firstUser);
        printAll();
        System.out.println();

        printAllUserQuery(thirdUser);
    }
}
