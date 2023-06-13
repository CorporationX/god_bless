package faang.school.godbless.task_1;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@ToString
@Getter
public class User {
    private final String name;
    private final int age;
    private final String placeOfWork;
    private final String address;
    public static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    public static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    public User(String name, int age, String placeOfWork, String address) {
        this.name = name;
        this.age = age;
        this.placeOfWork = placeOfWork;
        this.address = address;
        UserValidator.validateUser(this);
    }

    public static void main(String[] args) {
        List<User> userList = new ArrayList<>();
        userList.add(new User("Vasya", 19, "Google", "London"));
        userList.add(new User("Natasha", 19, "Google", "New York"));
        userList.add(new User("Igor", 18, "Uber", "Amsterdam"));
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
            usersByAge.computeIfAbsent(user.age, k -> new ArrayList<>()).add(user);
        }
        return usersByAge;
    }
}
