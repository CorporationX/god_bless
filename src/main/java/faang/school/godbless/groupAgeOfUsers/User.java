package faang.school.godbless.groupAgeOfUsers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    private String name;
    private int age;
    private String placeOfJob;
    private String address;

    public User(String name, int age, String placeOfJob, String address) {
        this.name = name;
        this.age = age;
        this.placeOfJob = placeOfJob;
        this.address = address;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> userList) {
        Map<Integer, List<User>> mapGroupUsers = new HashMap<>();

        for (User user : userList) {
            int userAge = user.getAge();
            if (!mapGroupUsers.containsKey(userAge)) {
                mapGroupUsers.put(userAge, new ArrayList<>());
            }
            mapGroupUsers.get(userAge).add(user);
        }
        return mapGroupUsers;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPlaceOfJob() {
        return placeOfJob;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + this.name + '\'' +
                ", age=" + this.age +
                ", placeOfJob='" + this.placeOfJob + '\'' +
                ", address='" + this.address + '\'' +
                '}';
    }
}
