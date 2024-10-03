package school.faang.usergroup;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Getter
@EqualsAndHashCode

public class User {
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    private String name;
    private int age;
    private String job;
    private String address;

    public User(String name, int age, String job, String address) {
        if (name.isEmpty()){
            System.out.println("Name cannot be empty");
            throw new IllegalArgumentException("Name cannot be empty");
        } else if (age < 18) {
            throw new IllegalArgumentException("Age cannot be less than 18");
        } else if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Invalid job");
        } else if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Invalid address");
        }

        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }


    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> groupedUsers = new HashMap<>();
        for (User user : users) {
            if (!groupedUsers.containsKey(user.getAge())){
                groupedUsers.put(user.getAge(), new ArrayList<>(){{add(user);}});
            }else{
                groupedUsers.get(user.getAge()).add(user);
            }
        }
        return groupedUsers;
    }
    @Override
    public String toString() {
        return this.name;
    }
}
