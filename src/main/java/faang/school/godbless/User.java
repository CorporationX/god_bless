package faang.school.godbless;

import java.security.PrivateKey;
import java.util.*;

public class User {
    private static final Set<String> VALID_JOBS = new HashSet<>(Arrays.asList("Goggle", "Uber", "Amazon"));
    private static final Set<String> VALID_ADDRESSES = new HashSet<>(Arrays.asList("London", "New York", "Amsterdam"));

    private String name;
    private int age;
    private String workPlace;
    private String address;

    public User(String name, int age, String workPlace, String address) {

        if (name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException("Name cannot be empty");
        }
        if (age < 18){
            throw new IllegalArgumentException("Age cannot be less then 18");
        }
        if (!VALID_JOBS.contains(workPlace)){
            throw new IllegalArgumentException("Job must be one of the valid jobs" + VALID_JOBS);
        }
        if (!VALID_ADDRESSES.contains(address)){
            throw new IllegalArgumentException("Address must be one of the valid addresses" + VALID_ADDRESSES);
        }
        this.name = name;
        this.age = age;
        this.workPlace = workPlace;
        this.address = address;

    }

    @Override
    public String toString() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public static HashMap<Integer, List<User>> groupUsers(ArrayList<User> usersList) {
        HashMap<Integer, List<User>> usersGroupedByAge = new HashMap<>();
        for (User user : usersList) {
            int userAge = user.getAge();
            if (!(usersGroupedByAge.containsKey(userAge))) {
                usersGroupedByAge.put(userAge, new ArrayList<User>());
            }
            usersGroupedByAge.get(userAge).add(user);
        }
        return usersGroupedByAge;
    }
}
