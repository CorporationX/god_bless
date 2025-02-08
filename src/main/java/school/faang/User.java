package school.faang;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class User {
    private final int id;
    private final String name;
    private final String age;
    private final Set<String> activities = new HashSet<>();

    public User(int id, String name, String age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> hobbies) {
        Map<User, String> hobbyLovers = new HashMap<>();
        for (User user : users) {
            for (String hobby : hobbies) {
                if (user.getActivities().contains(hobby)) {
                    hobbyLovers.put(user, hobby);
                    break;
                }
            }
        }
        return hobbyLovers;
    }



    public static void main(String[] args) {
        User bob = new User(1, "Bob", "18");
        User mike = new User(2, "Mike", "18");
        User john = new User(3, "John", "18");
        User sarah = new User(4, "Sarah", "18");


        bob.addActivities("Drunk", "Swim", "BeatBox");
        mike.addActivities("Ride", "Run", "Drunk");
        john.addActivities("Football", "Basketball", "WatchTV");
        sarah.addActivities("Fly", "Swim", "Eat");


        List<User> users = new ArrayList<>();
        users.add(bob);
        users.add(mike);
        users.add(john);
        users.add(sarah);

        Set<String> hobbies = new HashSet<>();
        hobbies.add("Drunk");
        hobbies.add("Football");

        Map<User, String> hobbyLovers = User.findHobbyLovers(users, hobbies);
        for (Map.Entry<User, String> entry : hobbyLovers.entrySet()) {
            System.out.println(entry.getKey() + " loves: " + entry.getValue());
        }
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public Set<String> getActivities() {
        return activities;
    }

    public void addActivities(String... activities) {
        Collections.addAll(this.activities, activities);
    }

    @Override
    public String toString() {
        return "User:{" + "id=" + id + ", name=" + name +
                ", age=" + age + ", activities=" + activities + '}';
    }
}
