package faang.school.godbless.group_by;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    private String name;
    private Integer age;
    private String work;
    private String address;


    public User(String name, Integer age, String work, String address) {
        this.name = name;
        this.age = age;
        this.work = work;
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", work='" + work + '\'' +
                ", address='" + address + '\'' +
                '}';
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

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> listUser) {

        Map<Integer, List<User>> usersGroup = new HashMap<>();
        for (User user : listUser) {
            usersGroup.putIfAbsent(user.age, new ArrayList<>());
            usersGroup.get(user.age).add(user);
        }
        return usersGroup;
    }
}