package school.BJS2_29000;

import lombok.Getter;
import java.util.*;

@Getter
public class User {

    private String name;
    private int age;
    private String job;
    private String address;

    public final static String[] VALID_JOBS = { "Google", "Uber", "Amazon"};
    public final static String[] VALID_ADDRESSES = { "London", "New York", "Amsterdam"};

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> userGroups = new HashMap<>();
        for (User user : users) {
            userGroups.computeIfAbsent(user.age, k -> new ArrayList<>()).add(user);
        }
        return userGroups;
    }

    /* имя не может быть пустым;
       возраст не может быть меньше 18;
       место работы должно содержаться во множестве VALID_JOBS;
       адрес должен содержаться во множестве VALID_ADDRESSES.*/
    public User(String name, String address, String job, int age) {
        if(name == null) throw new IllegalArgumentException("name is null");
        else this.name = name;
        if(age < 18) throw new IllegalArgumentException("age is smaller than 18");
        else this.age = age;
        if(Arrays.stream(VALID_ADDRESSES).noneMatch(a -> a.equals(address))) throw new IllegalArgumentException("address is invalid");
        else this.address = address;
        if(Arrays.stream(VALID_JOBS).noneMatch(j -> j.equals(job))) throw new IllegalArgumentException("job is invalid");
        else this.job = job;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", job='" + job + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}