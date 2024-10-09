package school.faang.task1311;

import java.util.ArrayList;

public class Main {
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

        UserService.addUser(firstUser, userOneList);
        UserService.addUser(secondUser, userTwoList);
        UserService.addUser(thirdUser, userThreeList);

        UserService.printAll();
        System.out.println();

        Query queryToAdd = new Query(7, "Habr", 10);
        UserService.addQuery(firstUser, queryToAdd);
        UserService.printAll();
        System.out.println();

        UserService.removeUser(firstUser);
        UserService.printAll();
        System.out.println();

        UserService.printAllUserQuery(secondUser);
    }
}
