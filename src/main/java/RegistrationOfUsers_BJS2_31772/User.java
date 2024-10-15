package RegistrationOfUsers_BJS2_31772;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Getter
@Setter

@ToString

public class User {
    private String name;
    private int age;
    private String company;
    private String address;

    public static final Set<String> VALID_JOBS = Set.of ("Google", "Uber", "Amazon");
    public static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    public User(String name, int age, String company, String address){

        if (name ==null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name can't be empty");
        }
        if (age<18){
            throw new IllegalArgumentException("Age must be over 18");
        }
        if (!VALID_JOBS.contains(company)){
            throw new IllegalArgumentException("Company should be from following list: Google, Uber, Amazon ");
        }
        if (!VALID_ADDRESSES.contains(address)){
            throw new IllegalArgumentException("Company should be from following list: London, New York, Amsterdam ");
        }

    }

    public static Map <Integer, List<User>> groupUsers (List<User> users) {
        Map<Integer, List<User>> ageGroupList = new HashMap<>();

        for (User user : users) {
            int age = user.getAge();

            ageGroupList.putIfAbsent(age, new ArrayList<>());

            ageGroupList.get(age).add(user);
        }

        return ageGroupList;
    }
}