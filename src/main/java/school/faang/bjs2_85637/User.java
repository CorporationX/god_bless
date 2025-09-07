package school.faang.bjs2_85637;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Setter
@Getter

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

        for (Map.Entry<Integer, List<User>> entry : usersByAge.entrySet()) {
            System.out.println("Age - " + entry.getKey() + ":" + entry.getValue());
        }
        return usersByAge;
    }

    @Override
    public String toString() {
        return String.format(name);
    }


}
