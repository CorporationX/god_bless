package group_users_by_age;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class User {
    private String name;
    private int age;
    private String workPlace;
    private String address;
    private final Set<String> VALID_JOBS = new HashSet<>(Set.of("Google", "Uber", "Amazon"));
    private final Set<String> VALID_ADDRESSES = new HashSet<>(Set.of("London", "New York", "Amsterdam"));
    private static final int ALLOWED_AGE = 18;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getWorkPlace() {
        return workPlace;
    }

    public String getAddress() {
        return address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setWorkPlace(String workPlace) {
        this.workPlace = workPlace;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public User(String name, int age, String workPlace, String address) {
        if (name.isEmpty() || age < 18 || !VALID_JOBS.contains(workPlace) || !VALID_ADDRESSES.contains(address)) {
            try {
                throw new IllegalArgumentException();
            } catch (IllegalArgumentException e) {
                System.out.println("!ERROR!\nYOUR ARGUMENT IS ILLEGAL!");
            }
        }

    }

    public static Map<Integer, List<User>> groupUsers(List<User> userList) {
        Map<Integer, List<User>> groupUsers = new HashMap<>();
        for (User user : userList) {
            if (!(groupUsers.containsKey(user.age))) {
                groupUsers.put(user.age, new ArrayList<>());
            }
            groupUsers.get(user.age).add(user);
        }


        return groupUsers;
    }

}
