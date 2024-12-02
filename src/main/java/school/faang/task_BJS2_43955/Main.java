package school.faang.task_BJS2_43955;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        ArrayList<User> users = getUsers();

        HashSet<String> hobbiesToFind_1 = new HashSet<>();
        hobbiesToFind_1.add("Football");
        hobbiesToFind_1.add("Programming");

        HashSet<String> hobbiesToFind_2 = new HashSet<>();
        hobbiesToFind_2.add("Tennis");
        hobbiesToFind_2.add("Diving");

        HashSet<String> hobbiesToFind_3 = new HashSet<>();
        hobbiesToFind_3.add("Games");

        printHobbyLovers(User.findHobbyLovers(users, hobbiesToFind_1));
        printHobbyLovers(User.findHobbyLovers(users, hobbiesToFind_2));
        printHobbyLovers(User.findHobbyLovers(users, hobbiesToFind_3));
    }

    private static void printHobbyLovers(Map<User, String> hobbyLovers) {
        for (Map.Entry<User, String> userHobbyEntry : hobbyLovers.entrySet()) {
            System.out.println(userHobbyEntry.getKey());
            System.out.println(userHobbyEntry.getValue());
        }
        System.out.println("---------------------------------------");
    }

    private static ArrayList<User> getUsers() {
        Set<String> hobbiesForFirstTestUser = new HashSet<>();
        hobbiesForFirstTestUser.add("Games");
        hobbiesForFirstTestUser.add("Tennis");
        hobbiesForFirstTestUser.add("Diving");

        HashSet<String> hobbiesForSecondTestUser = new HashSet<>();
        hobbiesForSecondTestUser.add("Football");
        hobbiesForSecondTestUser.add("Programming");
        hobbiesForSecondTestUser.add("Games");

        User testUser1 = new User(1, "TestUser1", 20, hobbiesForFirstTestUser);
        User testUser2 = new User(2, "TestUser2", 22, hobbiesForSecondTestUser);

        ArrayList<User> users = new ArrayList<>();
        users.add(testUser1);
        users.add(testUser2);
        return users;
    }
}
