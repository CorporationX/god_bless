package school.faang.bjs2_31882;

import java.util.Set;
import java.util.HashSet;
import java.util.*;

public class User {
    private long id;
    private String name;
    private int age;
    private Set<String> activities;

    public User(long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.activities = new HashSet<>();
    }

    public long getId() {
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


    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public void addActivity(String activity) {
        activities.add(activity);
    }


    public void removeActivity(String activity) {
        activities.remove(activity);
    }

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> hobbies) {
        Map<User, String> result = new HashMap<>();

        for (User user : users) {
            for(String activity : user.getActivities()){
                if(hobbies.contains(activity)){
                    result.put(user,activity);
                    break;
                }
            }
            Set<String> commonHobbies = new HashSet<>(user.getActivities());
            commonHobbies.retainAll(hobbies);
            if (!commonHobbies.isEmpty()) {
                String hobbiesList = String.join(" , ", commonHobbies);
            }
        }
        return result;
    }

    public static void main(String[] args){
        User user1 = new User(1,"Alice",25);
        user1.addActivity("Running");
        user1.addActivity("Swimming");

        User user2 = new User(2,"Bob",33);
        user2.addActivity("Cycling");
        user2.addActivity("Climing");

        User user3 = new User(3,"Charly",25);
        user3.addActivity("Coding");
        user3.addActivity("Reading");

        List<User> users = Arrays.asList(user1,user2,user3);
        Set<String> hobbies = new HashSet<>(Arrays.asList("Running", "Swimming"));

        Map<User, String> hobbyLovers = findHobbyLovers(users, hobbies);
        for(Map.Entry<User, String> entry : hobbyLovers.entrySet()){
            System.out.println(entry.getKey().getName() + " loves " + entry.getValue());
        }
    }
}


