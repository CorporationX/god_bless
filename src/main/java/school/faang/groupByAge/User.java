package school.faang.groupByAge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class User {
    private String name;
    private int age;
    private String workAddress;
    private String homeAddress;

    public User(String name, int age, String workAddress, String homeAddress) {
        this.name = name;
        this.age = age;
        this.workAddress = workAddress;
        this.homeAddress = homeAddress;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> userList) {

        Map<Integer, List<User>> usersByAge = new HashMap<>();

        for (User user : userList) {
            int age = user.getAge();

            if (!usersByAge.containsKey(age)) {
                usersByAge.put(age, new ArrayList<>());
            }
            usersByAge.get(age).add(user);
        }

        for (Map.Entry<Integer, List<User>> entry : usersByAge.entrySet() ) {
            System.out.println("Age - " + entry.getKey() + ":" + entry.getValue());
        }
        return usersByAge;
    }

    @Override
    public String toString() {
        return String.format(name);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setWorkAddress(String workAddress) {
        this.workAddress = workAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getWorkAddress() {
        return workAddress;
    }

    public String getHomeAddress() {
        return homeAddress;
    }


}
