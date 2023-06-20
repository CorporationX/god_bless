package User_registration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class User {
    private String name;
    private int age;
    private String placeOfWork;
    private String address;

    public static Set<String> VALID_JOBS = new HashSet<>(Arrays.asList("Google", "Uber", "Amazon"));
    public static Set<String> VALID_ADDRESSES = new HashSet<>(Arrays.asList("London", "New York", "Amsterdam"));

    public User(String name, int age, String placeOfWork, String address){
        if (name.isEmpty() || age<18 ||
                !VALID_JOBS.contains(placeOfWork) ||
                !VALID_ADDRESSES.contains(address)){
            throw new IllegalArgumentException();
        } else{
            this.name = name;
            this.age = age;
            this.placeOfWork = placeOfWork;
            this.address = address;
        }

    }
    public static Map<Integer, List<User>> groupUsers(List<User> users){
        Map<Integer, List<User>> usersMap = new HashMap<>();

        for(User user: users){
            if (!usersMap.containsKey(user.age)){
                usersMap.put(user.age, new ArrayList<>());
            }
            usersMap.get(user.age).add(user);
        }
        return usersMap;
    }


}
