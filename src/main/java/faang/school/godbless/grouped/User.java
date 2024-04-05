package faang.school.godbless.grouped;

import lombok.Getter;
import lombok.Setter;


import java.util.*;

@Getter
@Setter
public class User {
    private String name;
    private int age;
    private String location;
    private String address;

    public User(String name, int age, String location, String address) {
        this.name = name;
        this.age = age;
        this.location = location;
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age && Objects.equals(name, user.name) && Objects.equals(location, user.location) && Objects.equals(address, user.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, location, address);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", placeOfWork='" + location + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users){
        Map<Integer, List<User>> groupedUsers = new HashMap<>();

        for (User user : users) {
            int age = user.getAge();
            if (!groupedUsers.containsKey(age)) {
                groupedUsers.put(age, new ArrayList<>());
            }
            groupedUsers.get(age).add(user);
        }
        return groupedUsers;
    }
}
