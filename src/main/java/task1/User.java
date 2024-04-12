package task1;

import java.util.*;

public class User {
    private String name;
    private int age;
    private String work;
    private String address;
    static final Set<String> VALID_JOBS = new HashSet<>();
    static final Set<String> VALID_ADDRESSES = new HashSet<>();

    public User(String name, int age, String work, String address) throws IllegalArgumentException {
        VALID_JOBS.add("Google");
        VALID_JOBS.add("Uber");
        VALID_JOBS.add("Amazon");
        VALID_ADDRESSES.add("London");
        VALID_ADDRESSES.add("New York");
        VALID_ADDRESSES.add("Amsterdam");
        if (name.isEmpty() || age < 18 || !VALID_JOBS.contains(work) || !VALID_ADDRESSES.contains(address))
            throw new IllegalArgumentException();
        this.name = name;
        this.age = age;
        this.work = work;
        this.address = address;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> list) {
        Map<Integer, List<User>> sortedUsersMap = new HashMap<>();
        for (User user : list) {
            if (!sortedUsersMap.containsKey(user.age)) {
                List<User> users = new ArrayList<>();
                users.add(user);
                sortedUsersMap.put(user.age, users);
                continue;
            }
            sortedUsersMap.get(user.age).add(user);
        }
        return sortedUsersMap;
    }
}