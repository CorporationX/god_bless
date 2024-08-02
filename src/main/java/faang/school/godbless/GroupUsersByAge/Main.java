package faang.school.godbless.GroupUsersByAge;

import java.util.*;

public class Main {

    private static final List<User> USERS = new ArrayList<>();

    public static void main(String[] args) {

        USERS.add(new User(15, "Valera", "McDonalds", "Pushkina-Kolotushkina"));
        USERS.add(new User(15, "Vasya", "McDonalds", "Pushkina-Kolotushkina"));
        USERS.add(new User(14, "Misha", "Google", "Pushkina-Kolotushkina"));
        USERS.add(new User(14, "Danya", "None", "Pushkina-Kolotushkina"));
        USERS.add(new User(16, "Katya", "None", "Pushkina-Kolotushkina"));

        Map<Integer, List<User>> groupedByAge = User.groupUsersByAge(USERS);

        groupedByAge.forEach( (age, groupedUsers) -> {
            System.out.println(age + ": " + groupedUsers.toString());
        } );
    }
}
