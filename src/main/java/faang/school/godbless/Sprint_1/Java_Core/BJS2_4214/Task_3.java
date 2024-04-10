
package faang.school.godbless.Sprint_1.Java_Core.BJS2_4214;

import java.util.*;

import static faang.school.godbless.Sprint_1.Java_Core.BJS2_4214.User.findHobbyLovers;

public class Task_3 {
    public static void main(String[] args) {
        // Example usage:
        User user1 = new User(1, "Alice", 25, new HashSet<>(Arrays.asList("Reading", "Hiking")));
        User user2 = new User(2, "Bob", 30, new HashSet<>(Arrays.asList("Swimming", "Playing")));
        User user3 = new User(3, "Charlie", 22, new HashSet<>(Arrays.asList("Hiking", "Photography")));
        List<User> userList = new ArrayList<>();  //Arrays.asList(user1, user2, user3);
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        Set<String> targetActivities = new HashSet<>(Arrays.asList("Playing","Hiking", "Photography"));
        Map<User, String> hobbyLovers = findHobbyLovers(userList, targetActivities);
        for (Map.Entry<User, String> entry : hobbyLovers.entrySet()) {
            System.out.println(entry.getKey().getName() + " loves " + entry.getValue());
        }
    }
}
class User {
    private int id;
    private String name;
    private int age;
    private Set<String> activities;
    public User(int id, String name, int age, Set<String> activities) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.activities = activities;
    }
    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> targetActivities) {
        Map<User, String> result = new HashMap<>();
        for (User user : users) {
            for (String activity : user.getActivities()) {
                if (targetActivities.contains(activity)) {
                    result.put(user, activity);
                    break;
                }
            }
        }
        return result;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public Set<String> getActivities() {
        return activities;
    }
    public void setActivities(Set<String> activities) {
        this.activities = activities;
    }
}



