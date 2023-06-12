package faang.school.godbless;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class User {
    private String name;
    private int age;
    private String work;
    private String address;
    private static final Set<String> VALID_JOBS = new HashSet<>() {{
        add("Google");
        add("Uber");
        add("Amazon");
    }};
    private static final Set<String> VALID_ADDRESSES = new HashSet<>() {{
        add("London");
        add("New York");
        add("Amsterdam");
    }};


    public static Map<Integer, List<User>> groupUsers(List<User> userList) {
        return userList.stream().collect(Collectors.groupingBy(User::getAge));
    }

    public User(String name, int age, String work, String address) {
        if (name == null || name.trim().length()==0 || age < 18 || !VALID_JOBS.contains(work) || !VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.age = age;
        this.work = work;
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


    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", work='" + work + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
