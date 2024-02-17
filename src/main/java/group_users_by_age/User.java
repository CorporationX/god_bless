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

    public User(String name, int age, String workPlace, String address) throws Exception {
        validation(name, age, workPlace, address);
        this.name = name;
        this.age = age;
        this.workPlace = workPlace;
        this.address = address;

    }

    private void validation(String name, int age, String workPlace, String address) throws Exception {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("!ERROR!\nargument \"name\" can't be empty");
        } else if (age < 18) {
            throw new IllegalArgumentException("!ERROR!\nargument \"age\" must be more than 17");
        } else if (!VALID_JOBS.contains(workPlace)) {
            throw new IllegalArgumentException("!ERROR!\nargument \"workPlace\" must be \"Google\", \"Uber\" or \"Amazon\"");
        } else if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("!ERROR!\nargument \"address\" must be \"London\", \"New York\" or \"Amsterdam\"");
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
