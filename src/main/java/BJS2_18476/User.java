package BJS2_18476;

import lombok.ToString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@ToString
public class User {

    final Set<String> VALID_JOBS = new HashSet<>(Arrays.asList("Google","Uber","Amazon"));
    final Set<String> VALID_ADDRESSES = new HashSet<>(Arrays.asList("London","New York","Amsterdam"));

    String name;
    int age;
    String job;
    String address;

    public User(String name, int age, String job, String address) {
        if(name.isEmpty() || age < 18 ||
                !VALID_ADDRESSES.contains(address) || !VALID_JOBS.contains(job)){
            throw new IllegalArgumentException();
        }
        else{
            this.name = name;
            this.age = age;
            this.address = address;
            this.job = job;
        }

    }

    public static Map<Integer, List<User>> groupUsers(List<User> users){

        Map<Integer,List<User>> resultMap = new HashMap<>();

        for(User user : users){
            if(!resultMap.containsKey(user.age)){
                resultMap.put(user.age, new ArrayList<>());
                resultMap.get(user.age).add(user);
            }
            else{
                resultMap.get(user.age).add(user);
            }
        }

        return resultMap;
    }
}