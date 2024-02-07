package faang.school.godbless.main;

import java.util.*;

public class User {
    private String name;
    private int age;
    private String work;
    private String address;

    public final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    public final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    public User(String name, int age, String work, String address) throws IllegalArgumentException {
        if (!name.isEmpty() && age >= 18 && VALID_JOBS.contains(work) && VALID_ADDRESSES.contains(address)) {
            this.name = name;
            this.age = age;
            this.work = work;
            this.address = address;
        } else {
            throw new IllegalArgumentException();
        }
    }

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
