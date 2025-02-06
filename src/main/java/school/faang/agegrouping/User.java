package school.faang.agegrouping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class User {
    private String name;
    private int age;
    private String workPlace;
    private String address;

    public User(String name, int age, String workPlace, String address) {
        this.name = name;
        this.age = age;
        this.workPlace = workPlace;
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public String getWorkPlace() {
        return workPlace;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "User{"
                + "name= " + getName() + '\''
                + ", age= " + getAge()
                + ", work place= " + getWorkPlace() + '\''
                + ", address= " + getAddress() + '\''
                + '}';
    }

    public static HashMap<Integer, List<User>> groupingByAge(List<User> users) {
        HashMap<Integer, List<User>> result = new HashMap<>();
        for (User user : users) {
            result.putIfAbsent(user.getAge(), new ArrayList<>());
            result.get(user.getAge()).add(user);

        }
        return result;
    }
}
