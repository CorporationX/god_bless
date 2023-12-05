package faang.school.godbless.BJS2_402;

import lombok.Data;

import java.util.*;

@Data
public class User {

    public final static Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    public final static Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    public User (String name, int age, String job, String address) {
        if (name.isEmpty()
                || age < 18
                || !VALID_JOBS.contains(job)
                || !VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Wrong data");
        }
        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }

    private String name;
    private int age;
    private String job;
    private String address;

    public User (String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static Map<Integer, List<User>> groupUsers (List<User> userList) {

        Map<Integer, List<User>> groupUserMap = new HashMap<>();

        for (User x : userList) {

            int currentUserAge = x.getAge();

            List<User> userSet =
                    groupUserMap.getOrDefault(x.getAge(), new ArrayList<>());

            userSet.add(x);
            groupUserMap.put(currentUserAge, userSet);

        }

        return groupUserMap;
    }
}
