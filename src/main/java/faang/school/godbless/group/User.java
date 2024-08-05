package faang.school.godbless.group;

import lombok.AllArgsConstructor;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class User {
    @NonNull private String name;
    @NonNull private Integer age;
    @NonNull private String workAddress;
    @NonNull private String homeAddress;

    private static final Set<String> VALID_JOBS = new HashSet<>(Arrays.asList("Google", "Uber", "Amazon"));
    private static final Set<String> VALID_ADDRESSES = new HashSet<>(Arrays.asList("London", "New York", "Amsterdam"));

    public static Map<Integer, List<User>> groupUsers(List<User> userList){
        var userMap = new HashMap<Integer, List<User>>();
        for (User user : userList){
            addUser(userMap, user);
        }
        return userMap;
    }

    private static void addUser(Map<Integer, List<User>> userMap, User user){
        userMap.computeIfAbsent(user.age, k -> new ArrayList<>());
        userMap.get(user.age).add(user);
    }

    public User(@NonNull String name, @NonNull Integer age, @NonNull String workAddress, @NonNull String homeAddress) {
        if (age >= 18 && VALID_ADDRESSES.contains(homeAddress)
            && VALID_JOBS.contains(workAddress)){
            this.name = name;
            this.age = age;
            this.homeAddress = homeAddress;
            this.workAddress = workAddress;
        }else {
            throw new IllegalArgumentException();
        }
    }
}
