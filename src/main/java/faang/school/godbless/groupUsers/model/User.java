package faang.school.godbless.groupUsers.model;

import java.util.*;

public class User {
    public static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    public static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private String name;
    private int age;
    private String workPlace;
    private String address;

    public User(String name, int age, String workPlace, String address) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("имя не может быть пустым");
        }
        if (age < 18) {
            throw new IllegalArgumentException("возраст не может быть меньше 18");
        }
        if (!VALID_JOBS.contains(workPlace)) {
            throw new IllegalArgumentException("место работы должно содержаться во множестве VALID_JOBS");
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("адрес должен содержаться во множестве VALID_ADDRESSES");
        }
        this.name = name;
        this.age = age;
        this.workPlace = workPlace;
        this.address = address;
    }

    public static Map<Integer, List<User>> groupUsersByAge(List<User> users) {
        Map<Integer, List<User>> groupedUsers = new HashMap<>();
        for (User user : users) {
            if (groupedUsers.containsKey(user.age)) {
                groupedUsers.get(user.age).add(user);
            } else {
                List<User> newGroup = new ArrayList<>();
                newGroup.add(user);
                groupedUsers.put(user.age, newGroup);
            }
        }
        return groupedUsers;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", workPlace='" + workPlace + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
