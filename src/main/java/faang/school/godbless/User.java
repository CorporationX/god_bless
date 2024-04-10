package faang.school.godbless;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    private String name;
    private int age;
    private String jobPlace;
    private String address;

    public User(String name, int age, String jobPlace, String address) {
        this.name = name;
        this.age = age;
        this.jobPlace = jobPlace;
        this.address = address;
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

    public String getJobPlace() {
        return jobPlace;
    }

    public void setJobPlace(String jobPlace) {
        this.jobPlace = jobPlace;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public static Map<Integer, List<User>> groupUsers(List<User> userList) {
        Map<Integer, List<User>> groupedUsers = new HashMap<>();

        for (User user : userList) {
            int age = user.getAge();
            if (groupedUsers.containsKey(age)) {
                groupedUsers.get(age).add(user);
            } else {
                List<User> usersWithSameAge = new ArrayList<>();
                usersWithSameAge.add(user);
                groupedUsers.put(age, usersWithSameAge);
            }
        }
        return groupedUsers;
    }
}