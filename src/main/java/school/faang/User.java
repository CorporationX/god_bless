package school.faang;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class User {
    private int age;
    private String name;
    private String workPlace;
    private String address;

    public User(int age, String name, String workPlace, String address) {
        this.age = age;
        this.name = name;
        this.workPlace = workPlace;
        this.address = address;
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name, workPlace, address);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return  false;
        }
        User user = (User) obj;
        return age == user.age && Objects.equals(name, user.name) && Objects.equals(address, user.address)
                && Objects.equals(workPlace, user.workPlace);
    }

    @Override
    public String toString() {
        return "name : " + name + ", age : " + age +   ", workplace : " + workPlace + ", address : " + address;
    }

    public static List<User> findUsersByAge(int age, List<User> users) {
        List<User> usersOfaSpecificAge = new ArrayList<>();
        for (User user : users) {
            if (user.age == age) {
                usersOfaSpecificAge.add(user);
            }
        }
        return usersOfaSpecificAge;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Set<Integer> ageSet = new HashSet<>();
        for (User user : users) {
            ageSet.add(user.age);
        }
        Map<Integer, List<User>> ageUsersMap = new HashMap<>();
        for (int age : ageSet) {
            ageUsersMap.put(age, findUsersByAge(age, users));
        }
        return ageUsersMap;
    }
}
