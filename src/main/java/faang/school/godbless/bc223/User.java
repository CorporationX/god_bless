package faang.school.godbless.bc223;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Data

public class User {
     private String name;
     private int age;
    private String workPlace;
    private String address;

    private static final Set<String> VALID_JOBS = Set.of("Google","Uber","Amazon" );
    private static final Set<String> VALID_ADDRESSES = Set.of("London","New York","Amsterdam");

    public User(String name, int age, String workPlace, String address)throws IllegalArgumentException {

        if (name == null || age<18 || !VALID_JOBS.contains(workPlace) || !VALID_ADDRESSES.contains(address))
        {
            throw new IllegalArgumentException("Wrong arguments");
        }
        this.name = name;
        this.age = age;
        this.workPlace = workPlace;
        this.address = address;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> groupUsers = new HashMap<>();
        for (User user : users) {
            if (groupUsers.containsKey(user.age)) {
                groupUsers.get(user.age).add(user);
            }else
            {
                List<User> newGroup = new ArrayList<>();
                groupUsers.put(user.age, newGroup);
                newGroup.add(user);
            }
        }
        return groupUsers;
    }
}