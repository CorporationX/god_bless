package faang.school.godbless;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    private String username;
    private int age;
    private String job;
    private String address;

    public User(String username, int age, String job, String address) {
        this.username = username;
        this.age = age;
        this.job = job;
        this.address = address;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public String getJob() {
        return job;
    }

    public String getUsername() {
        return username;
    }

    public String getAddress() {
        return address;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users){
        Map<Integer, List<User>> groups = new HashMap();
        for(User user : users){
            int age = user.getAge();
            if (!groups.containsKey(age)){
                groups.put(age, new ArrayList<>());
            }
            groups.get(age).add(user);
        }
        return groups;
    }
}


