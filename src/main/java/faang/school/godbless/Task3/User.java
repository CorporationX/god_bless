package faang.school.godbless.Task3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class User {

    private String name;
    private int age;
    private String place;
    private String address;

    public User(String name, int age, String place, String address) {
        this.name = name;
        this.age = age;
        this.place = place;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPlace() {
        return place;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return name;
    }

    public static HashMap<Integer, List<User>> groupUsers(List<User> users) {
        HashMap<Integer, List<User>> userGroups = new HashMap<>();
        for (User user : users) {
            int key = user.getAge();
            List<User> sameAge = new ArrayList<>();
            for (User user1 : users) {
                if (user1.getAge() == key) {
                    sameAge.add(user1);
                }
            }
            userGroups.put(key, sameAge);
        }
        return userGroups;
    }

    public static void main(String[] args) {

        List<User> users = new ArrayList<>();
        users.add(new User("Adnrew", 26, "Moscow", "Street1"));
        users.add(new User("John", 25, "Moscow", "Street1"));
        users.add(new User("Jane", 25, "Moscow", "Street1"));
        users.add(new User("Jordan", 26, "Moscow", "Street1"));
        HashMap<Integer, List<User>> ageGroups = groupUsers(users);
        System.out.println(ageGroups);

    }

}