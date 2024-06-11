package faang.school.godbless.group_users_by_age;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.*;

// Я надеюсь коменты можно на английском писать, у меня клава только с английской расскладкой и я прям мучабсь писать на русском :)

//Assume User Object is immutable and all fields are required
@ToString
public class User {
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private static final int AGE_CUT_OFF = 18;

    private String name;
    private int age;
    private String companyName;
    private String address;

    public User(String name, int age, String companyName, String address) {
        if(name == null || name.isEmpty() || name.contains(" ")) {
            throw new IllegalArgumentException("Name cannot be null or empty or have spaces: " + name);
        }

//        no more magic numbers
        if(age < AGE_CUT_OFF) {
            throw new IllegalArgumentException("Underage cannot be employed: " + age);
        }

        if(!VALID_JOBS.contains(companyName)) {
            throw new IllegalArgumentException("Company name is not valid: " + companyName);
        }

        if(!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Address is not valid: " + address);
        }

        this.name = name;
        this.age = age;
        this.companyName = companyName;
        this.address = address;
    }

    //Quite self-explanatory
    public static Map<Integer, List<User>> groupUsers(List<User> userList) {
        Map<Integer, List<User>> userMap = new HashMap<Integer, List<User>>();
        for (User user : userList){
//            Intellij black magic lol, extremely handy method fr, I also love how its lambda func. Js dev in me is very happy
            List<User> users = userMap.computeIfAbsent(user.age, k -> new ArrayList<User>());
            users.add(user);
        }
        return userMap;
    }
}

