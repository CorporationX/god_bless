package User_Registration;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

@Getter
@Setter
public class User {
    private String name;
    private int age;
    private String job;
    private String address;
    private final static Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private final static Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    final private static int legalAge = 18;

    public static HashMap<Integer, List<User>> groupUsers(List<User> userList) {
        HashMap<Integer, List<User>> userMap = new HashMap<>();
        for (User user : userList) {
            if (!userMap.containsKey(user.getAge())) {
                userMap.put(user.getAge(), new ArrayList<>());
            }
            userMap.get(user.getAge()).add(user);
        }
        return userMap;
    }
    public User(String name, int age, String job, String address) throws IllegalArgumentException {
        if (!name.isBlank() && age >= legalAge && VALID_JOBS.contains(job) && VALID_ADDRESSES.contains(address)) {
            this.name = name;
            this.age = age;
            this.job = job;
            this.address = address;
        } else
            throw new IllegalArgumentException("Incorrect User Data");
    }

    @Override
    public String toString() {
        return "\n" + "Name – " + name +
                ", Job – " + job +
                ", Address – " + address;
    }

}