package school.faang;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    private String name;
    private Integer age;
    private String workingPlace;
    private String address;

    public User(String name, Integer age, String workingPlace, String address) {
        this.name = name;
        this.age = age;
        this.workingPlace = workingPlace;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getWorkingPlace() {
        return workingPlace;
    }

    public void setWorkingPlace(String workingPlace) {
        this.workingPlace = workingPlace;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> list) {
        Map<Integer, List<User>> userMap = new HashMap<>();

        for (User user : list) {
            userMap.putIfAbsent(user.getAge(), new ArrayList<>());
            userMap.get(user.getAge()).add(user);
        }
        return userMap;
    }
}
