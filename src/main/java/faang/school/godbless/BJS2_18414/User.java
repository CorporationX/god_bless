package faang.school.godbless.BJS2_18414;

import java.util.*;

public record User(String name, int age, String jobPlace, String address) {
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    public User{
        if(name.isBlank()){
            throw new IllegalArgumentException("Name is empty");
        }
        if(age < 18){
            throw new IllegalArgumentException("Wrong age");
        }
        if(!VALID_JOBS.contains(jobPlace)){
            throw new IllegalArgumentException("Place of job does not matches");
        }
        if(!VALID_ADDRESSES.contains(address)){
            throw new IllegalArgumentException("Address does not matches");
        }
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users){
        Map<Integer, List<User>> usersByAge = new HashMap<>();

        users.forEach(user -> {
            usersByAge.computeIfAbsent(user.age, (x) -> new ArrayList<>()).add(user);
        });

        return usersByAge;
    }
}
