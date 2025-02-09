package school.faang.BJS2_56433;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class User {
    private String name;
    private int age;
    private String workplace;
    private String address;

    public User(String name, int age, String workplace, String address) {
        this.name = name;
        this.age = age;
        this.workplace = workplace;
        this.address = address;
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

    public String getWorkplace() {
        return workplace;
    }

    public void setWorkplace(String workplace) {
        this.workplace = workplace;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return String.format("User{name='%s', age=%d, workplace='%s', address='%s'}", name, age, workplace, address);
    }

    static Map<Integer, List<User>> groupUsers(List<User> users) {
        if (users == null) {
            return new HashMap<>();
        }

        Map<Integer, List<User>> usersByAge = users.stream().collect(Collectors.groupingBy(User::getAge));

        return usersByAge;

    }

}