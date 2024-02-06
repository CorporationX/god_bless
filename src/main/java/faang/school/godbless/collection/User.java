package faang.school.godbless.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class User{
    private String name;
    private int age;
    private String workPlace;
    private String address;

    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");



    public User(String name, int age, String workPlace, String address) throws IllegalArgumentException {
        if (!name.isEmpty() & age >= 18 & VALID_JOBS.contains(workPlace) & VALID_ADDRESSES.contains(address)){
            this.name = name;
            this.age = age;
            this.workPlace = workPlace;
            this.address = address;
        }else{
            throw new IllegalArgumentException("Some input data is invalid");
        }

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getWorkPlace() {
        return workPlace;
    }

    public void setWorkPlace(String workPlace) {
        this.workPlace = workPlace;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public static Map<Integer, List<User>> groupUsers (List<User> users){
        Map<Integer, List<User>> map = new HashMap<>();
        for (User user : users){
            int age = user.getAge();
            if (!map.containsKey(age)){
                map.put(age, new ArrayList<>());
            }
            map.get(age).add(user);
        }
        return map;
    }

}