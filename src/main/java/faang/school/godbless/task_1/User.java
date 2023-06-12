package faang.school.godbless.task_1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class User {
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private final String name;
    private final int age;
    private final String workPlace;
    private final String address;

    public User(String name, int age, String workPlace, String address) {
        this.name = name;
        this.age = age;
        this.workPlace = workPlace;
        this.address = address;
    }

    private void checkName(String name) {
        if (null == name || name.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    private void checkAge(int age) {
        if (age < 18) {
            throw new IllegalArgumentException();
        }
    }

    private void checkValidJobs(String workPlace) {
        if (!VALID_JOBS.contains(workPlace)) {
            throw new IllegalArgumentException();
        }
    }

    private void checkValidAddress(String address) {
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException();
        }
    }

    public static Map<Integer, List<User>> usersGroup(List<User> userList) {
        Map<Integer, List<User>> groupUsers = new HashMap<>();
        for (User user : userList) {
            int age = user.age;
            if (groupUsers.containsKey(age)) {
                groupUsers.get(age).add(user);
            } else {
                List<User> anotherList = new ArrayList<>();
                anotherList.add(user);
                groupUsers.put(age, anotherList);
            }
        }
        return groupUsers;
    }
}
