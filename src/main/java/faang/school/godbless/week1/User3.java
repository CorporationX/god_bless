package faang.school.godbless.week1;

import java.util.*;

//import static jdk.internal.org.jline.utils.InfoCmp.Capability.*;

public class User3 {

    private int id;
    private String name;
    private int age;
    private Set<String> activities;

    //Constructor
    public User3(int id, String name, int age, Set<String> activities) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.activities = activities;

    }
    //Gettery

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Set<String> getActivities() {
        return activities;
    }

    //Method find hobby lovers
    public static Map<User3, String> findHobbyLowers(List<User3> users, Set<String> targetActivities) {
        Map<User3, String> hobbyLovers = new HashMap<>();
        for (User3 user : users) {
            for (String activity : user.getActivities()) {
                if (targetActivities.contains(activity)) {
                    hobbyLovers.put(user, activity);
                    break;
                }
            }
        }

        return hobbyLovers;
    }

    @Override
    public String toString() {
        return "User3{" +
                "id=" + id +
                ", name=' " + name + '\'' +
                ", age= " + age +
                ", activities=" + activities +
                '}';
    }


    //Testing method
    public static void main(String[] args) {
        // Creating users with activities
        User3 user1 = new User3(1, "Alice", 25, new HashSet<>(Arrays.asList("Reading", "Swimming", "Coding")));
        User3 user2 = new User3(2, "Bob", 30, new HashSet<>(Arrays.asList("Cooking", "Cycling", "Reading")));
        User3 user3 = new User3(3, "Charlie", 22, new HashSet<>(Arrays.asList("Gaming", "Swimming", "Hiking")));

        // Creating a list of users
        List<User3> users = Arrays.asList(user1, user2, user3);
        //Creating a target activities

        Set<String> targetActivities = new HashSet<>(Arrays.asList("Coding", "Gaming", "Swimming"));
        // Finding hobby lovers
        Map<User3, String> hobbyLovers = User3.findHobbyLowers(users, targetActivities);

        // Results out
        for (Map.Entry<User3, String> entry : hobbyLovers.entrySet()) {
            System.out.println(entry.getKey().getName() + " loves " + entry.getValue());
        }
    }
}