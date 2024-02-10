package faang.school.godbless.main;


import java.util.*;

public class User {
    private String name;
    private int age;
    private String work;
    private String address;
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private static final int adultAge = 18;

    private static void validateUser(String name, int age, String work, String address) throws IllegalArgumentException {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Name can not be blank!");
        }
        if (age < adultAge) {
            throw new IllegalArgumentException("User must be older then 18!");
        }
        if (VALID_JOBS.contains(work)) {
            throw new IllegalArgumentException("It is not valid job!");
        }
        if (VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("It is not valid address!");
        }
    }

    public User(String name, int age, String work, String address) throws IllegalArgumentException {
        validateUser(name, age, work, address);
        this.name = name;
        this.age = age;
        this.work = work;
        this.address = address;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> result = new HashMap<>();
        for (User user : users) {
            int age = user.getAge();
            List<User> thisAgeUsers;
            if (!Objects.isNull(result.get(age))) {
                thisAgeUsers = result.get(age);
                thisAgeUsers.add(user);
            } else {
                thisAgeUsers = new ArrayList<>();
                thisAgeUsers.add(user);
            }
            result.put(age, thisAgeUsers);
        }
        return result;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getWork() {
        return work;
    }

    public String getAddress() {
        return address;
    }
}
