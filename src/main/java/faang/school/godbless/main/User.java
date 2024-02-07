package faang.school.godbless.main;

import java.util.*;

public class User {
    private String name;
    private int age;
    private String work;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> result = new HashMap<>();
        for (User user : users) {
            int age = user.getAge();
            List<User> thisAgeUsers;
            if (!Objects.isNull(result.get(age))) {
                thisAgeUsers = result.get(age);
                thisAgeUsers.add(user);
            } else {
                thisAgeUsers = new ArrayList<>();
                thisAgeUsers.add(user);
            }
            result.put(age, thisAgeUsers);
        }
        return result;
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
}
