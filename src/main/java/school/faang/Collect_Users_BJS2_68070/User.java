package school.faang.Collect_Users_BJS2_68070;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    int id;
    String name;
    int age;
    String[] activitiesList;

    public User(int id, String name, int age, String[] activitiesList) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.activitiesList = activitiesList;
    }

    public Map<String, String> findHobbyLovers(List<User> users, String[] activities) {
        Map<String, String> retMap = new HashMap<>();
        for (User user : users) { // iterate through all given users
            for (String activity : activities) { // iterate through all given activities
                if (user.isHobbyPresent(activity)) { // user has an activity as a hobby
                    retMap.put(user.name, activity); // add user and activity to the map
                    break; // head to next user
                }
            }
        }
        return retMap;
    }

    public boolean isHobbyPresent(String hobby) {
        for (String activity : activitiesList) {
            if (hobby.equals(activity)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // Create several users with different hobbies
        User user1 = new User(1, "Alice", 30, new String[]{"Reading", "Hiking", "Photography"});
        User user2 = new User(2, "Bob", 25, new String[]{"Gaming", "Coding", "Reading"});
        User user3 = new User(3, "Charlie", 40, new String[]{"Painting", "Gardening", "Cooking"});
        User user4 = new User(4, "David", 28, new String[]{"Coding", "Running", "Music"});
        User user5 = new User(5, "Eve", 35, new String[]{"Traveling", "Photography", "Yoga"});
        User user6 = new User(6, "Frank", 22, new String[]{"Gaming"});
        User user7 = new User(7, "Grace", 45, new String[]{}); // User with no hobbies

        // Create a list of users
        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);
        users.add(user6);
        users.add(user7);

        // Create a list of hobbies to search for
        String[] hobbiesToFind1 = {"Reading", "Coding"};
        String[] hobbiesToFind2 = {"Photography", "Swimming"};
        String[] hobbiesToFind3 = {"Gaming"};
        String[] hobbiesToFind4 = {"NonExistentHobby"};

        // Test Case 1: Find users who like Reading or Coding
        System.out.println("\nTest Case 1: Finding users who like Reading or Coding");
        Map<String, String> lovers1 = new User(0, "", 0, null).findHobbyLovers(users, hobbiesToFind1);
        System.out.println("Hobby Lovers: " + lovers1); // Expected: {Alice=Reading, Bob=Reading, David=Coding}

        // Test Case 2: Find users who like Photography or Swimming
        System.out.println("\nTest Case 2: Finding users who like Photography or Swimming");
        Map<String, String> lovers2 = new User(0, "", 0, null).findHobbyLovers(users, hobbiesToFind2);
        System.out.println("Hobby Lovers: " + lovers2); // Expected: {Alice=Photography, Eve=Photography}

        // Test Case 3: Find users who like Gaming
        System.out.println("\nTest Case 3: Finding users who like Gaming");
        Map<String, String> lovers3 = new User(0, "", 0, null).findHobbyLovers(users, hobbiesToFind3);
        System.out.println("Hobby Lovers: " + lovers3); // Expected: {Bob=Gaming, Frank=Gaming}

        // Test Case 4: Find users who like a non-existent hobby
        System.out.println("\nTest Case 4: Finding users who like a non-existent hobby");
        Map<String, String> lovers4 = new User(0, "", 0, null).findHobbyLovers(users, hobbiesToFind4);
        System.out.println("Hobby Lovers: " + lovers4); // Expected: {}
    }
}