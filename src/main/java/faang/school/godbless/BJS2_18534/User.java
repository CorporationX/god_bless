package faang.school.godbless.BJS2_18534;

import java.util.*;

public class User {
    private final String name;
    private final int age;
    private final String workPlace;
    private final String address;

    public User(String name, int age, String workPlace, String address) {
        this.name = name;
        this.age = age;
        this.workPlace = workPlace;
        this.address = address;
    }

    @Override
    public String toString() {
        return name + '\'' + age + '\'' + workPlace;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age && Objects.equals(name, user.name) && Objects.equals(workPlace, user.workPlace) && Objects.equals(address, user.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, workPlace, address);
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> userGroups = new HashMap<>();

        for (User user : users) {
            if (!userGroups.containsKey(user.age)) {
                userGroups.put(user.age, new ArrayList<>(List.of(user)));
            } else {
                userGroups.get(user.age).add(user);
            }
        }
        return userGroups;
    }
}
