package school.faang.task_43955;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        ArrayList<User> users = getUsers();

        HashSet<String> hobbiesToFind1 = new HashSet<>();
        hobbiesToFind1.add("Football");
        hobbiesToFind1.add("Programming");

        printHobbyLovers(User.findHobbyLovers(users, hobbiesToFind1));

        HashSet<String> hobbiesToFind2 = new HashSet<>();
        hobbiesToFind2.add("Tennis");
        hobbiesToFind2.add("Diving");

        printHobbyLovers(User.findHobbyLovers(users, hobbiesToFind2));

        HashSet<String> hobbiesToFind3 = new HashSet<>();
        hobbiesToFind3.add("Games");

        printHobbyLovers(User.findHobbyLovers(users, hobbiesToFind3));
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
