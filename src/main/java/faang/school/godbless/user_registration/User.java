package faang.school.godbless.user_registration;

import java.util.*;

public class User {

    private String name;
    private int age;
    private String workplace;
    private String address;
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private static final int WORKING_AGE = 18;

    public User(String name, int age, String workplace, String address) {

        if(name.isBlank() || age < WORKING_AGE || !VALID_JOBS.contains(workplace)
                || !VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.age = age;
        this.workplace = workplace;
        this.address = address;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {

        Map<Integer, List<User>> usersMap = new HashMap<>();

        for (User user : users) {
            if (!usersMap.containsKey(user.age)) {
                usersMap.put(user.age, new ArrayList<>());
            }
            usersMap.get(user.age).add(user);
        }
        return usersMap;
    }
}