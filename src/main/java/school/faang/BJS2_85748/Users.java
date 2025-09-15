package school.faang.BJS2_85748;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Users {
    private String name;
    private int age;
    private String job;
    private String adress;

    public Users(String name, int age, String job, String adress) {
        this.name = name;
        this.age = age;
        this.job = job;
        this.adress = adress;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getJob() {
        return job;
    }

    public String getAdress() {
        return adress;
    }

    @Override
    public String toString() {
        return name + " (" + age + ", " + job + ", " + adress + ")";
    }

    public static Map<Integer, List<Users>> groupUsers(List<Users> usersList) {
        Map<Integer, List<Users>> usersByAge = new HashMap<>();
        for (Users user : usersList) {
            int age = user.getAge();
            if (!usersByAge.containsKey(age)) {
                usersByAge.put(age, new ArrayList<>());
            }
            usersByAge.get(age).add(user);
        }
        return usersByAge;
    }
}