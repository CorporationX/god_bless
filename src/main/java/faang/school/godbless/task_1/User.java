package faang.school.godbless.task_1;

import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@ToString
public class User {
    private String name;
    private int age;
    private String placeOfWork;
    private String address;
    public static final Set<String> VALID_JOBS = new HashSet<>();
    public static final Set<String> VALID_ADDRESSES = new HashSet<>();

    static {
        VALID_JOBS.add("Google");
        VALID_JOBS.add("Uber");
        VALID_JOBS.add("Amazon");
        VALID_ADDRESSES.add("London");
        VALID_ADDRESSES.add("New York");
        VALID_ADDRESSES.add("Amsterdam");
    }

    public User(String name, int age, String placeOfWork, String address) {
        if (!name.isBlank() && age >= 18 && VALID_JOBS.contains(placeOfWork) && VALID_ADDRESSES.contains(address)) {
            this.name = name;
            this.age = age;
            this.placeOfWork = placeOfWork;
            this.address = address;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public static void main(String[] args) {
        List<User> userList = new ArrayList<>();
        userList.add(new User("Vasya", 19, "FAANG", "London"));
        userList.add(new User("Natasha", 13, "Google", "New York"));
        userList.add(new User("Igor", 18, "Uber", "Voronezh"));
        userList.add(new User("Yevhenii", 25, "Google", "Amsterdam"));
        userList.add(new User("Matvei", 33, "Amazon", "London"));
        userList.add(new User("Ksenia", 18, "Uber", "Amsterdam"));
        userList.add(new User("Rostislav", 25, "Google", "Amsterdam"));
        userList.add(new User("Nikita", 25, "Uber", "New York"));
        userList.add(new User("Nadia", 19, "Google", "New York"));
        System.out.println(groupUsers(userList));
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> usersByAge = new HashMap<>();
        for (User user : users) {
            if (!usersByAge.containsKey(user.age)) {
                usersByAge.computeIfAbsent(user.age, k -> new ArrayList<>());
            }
            usersByAge.get(user.age).add(user);
        }
        return usersByAge;
    }
}
