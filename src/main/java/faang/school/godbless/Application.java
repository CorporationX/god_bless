package faang.school.godbless;


import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class Application {

    private static final Map<User, List<Query>> USER_LIST_MAP = new HashMap<>();



    public static void main(String[] args) {
        System.out.println("God Bless!");


        User firstUser = new User(1, "first");
        User secondUser = new User(2, "second");
        User thirdUser = new User(3, "third");
        User fourthUser = new User(4, "fourth");
        User fifthUser = new User(5, "fifth");

        Query firstQuery = new Query(1, "con1", 1.0);
        Query secondQuery = new Query(2, "con2", 2.0);
        Query thirdQuery = new Query(3, "con3", 1.7);
        Query fourthQuery = new Query(4, "con4", 1.8);
        Query fifthQuery = new Query(5, "con5", 3.0);
        Query sixthQuery = new Query(6, "con6", 4.0);
        Query seventhQuery = new Query(7, "con7", 5.0);
        Query eigthQuery = new Query(8, "con8", 1.2);
        Query ninthQuery = new Query(9, "con9", 6.0);
        Query tenthQuery = new Query(10, "con10", 6.0);

        addNewUserQuery(firstUser, firstQuery);
        addNewUserQuery(firstUser, secondQuery);
        addNewUserQuery(secondUser, thirdQuery);
        addNewUserQuery(secondUser, fourthQuery);
        addNewUserQuery(thirdUser, fifthQuery);
        addNewUserQuery(thirdUser, sixthQuery);
        addNewUserQuery(fourthUser, seventhQuery);
        addNewUserQuery(fourthUser, eigthQuery);
        addNewUserQuery(fifthUser, ninthQuery);
        addNewUserQuery(fifthUser, tenthQuery);

        getAllUsers();

        getStoryUserQuery(secondUser);
    }

    public static void addNewUserQuery(User user, Query query) {
            if (USER_LIST_MAP.containsKey(user)) {
                USER_LIST_MAP.get(user).add(query);
            } else {
                USER_LIST_MAP.put(user, new ArrayList<>());
                USER_LIST_MAP.get(user).add(query);
            }
    }

    public static void removeUserListQuery(User user) {
        USER_LIST_MAP.remove(user);
    }

    public static void getAllUsers() {
        for (Map.Entry<User, List<Query>> pair : USER_LIST_MAP.entrySet()) {
            System.out.println(pair.getKey());
            for (Query query : pair.getValue()) {
                System.out.println(query);
            }
            System.out.println();
        }
    }

    public static void getStoryUserQuery(User user) {
        List<Query> sortQuery = USER_LIST_MAP.get(user);
        for (int i = 0; i < sortQuery.size() - 1; i++) {
            for (int j = 0; j < sortQuery.size() - 1; j++) {
                if (sortQuery.get(j).getTimestamp() < sortQuery.get(j + 1).getTimestamp()) {
                    Query temp = sortQuery.get(j);
                    sortQuery.set(j, sortQuery.get(j + 1));
                    sortQuery.set(j + 1, temp);
                }
            }
        }

        for (Query i : sortQuery) {
            System.out.println(i);
        }
    }
}


