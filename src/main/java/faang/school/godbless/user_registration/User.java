package faang.school.godbless.user_registration;

import lombok.Data;

import java.util.*;

@Data
public class User {
    private String name;
    private int age;
    private String placeOfWork;
    private String address;

    private static final Set<String> VALID_JOBS = new HashSet<>(Arrays.asList("Google", "Uber", "Amazon"));
    private static final Set<String> VALID_ADDRESSES = new HashSet<>(Arrays.asList("London", "New York", "Amsterdam"));
    private static final int MIN_AGE = 18;

    public User(String name, int age, String placeOfWork, String address) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("The name is missing.");
        }
        if (age < MIN_AGE) {
            throw new IllegalArgumentException("Age less than 18.");
        }
        if (!VALID_JOBS.contains(placeOfWork)) {
            throw new IllegalArgumentException("The wrong place of work.");
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Invalid address.");
        } else {
            this.name = name;
            this.age = age;
            this.placeOfWork = placeOfWork;
            this.address = address;
        }
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> mapUser = new HashMap<>();

        for (User user : users) {
            if (!mapUser.containsKey(user.getAge())) {
                mapUser.put(user.getAge(), new ArrayList<>());
            }
            mapUser.get(user.getAge()).add(user);
        }
        return mapUser;
    }
}