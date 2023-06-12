package faang.school.godbless.task2;

import lombok.Getter;
import lombok.ToString;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@ToString(exclude = {"VALID_JOBS", "VALID_ADDRESSES"})
public class User {
    private final String VALID_JOBS = "Google, Uber, Amazon";
    private final String VALID_ADDRESSES = "London, New York, Amsterdam";

    private String name;
    @Getter
    private int age;
    private String worksPlace;
    private String address;

    public User(String name, int age, String worksPlace, String address) throws IllegalArgumentException {
        if (!name.isEmpty() && VALID_JOBS.contains(worksPlace) && VALID_ADDRESSES.contains(address)) {
            this.name = name;
            this.age = age;
            this.worksPlace = worksPlace;
            this.address = address;
        } else {
            throw new IllegalArgumentException();
        }

    }

    public static Map<Integer, LinkedList<User>> groupUsers(List<User> users) {
        Map<Integer, LinkedList<User>> sortsUsers = new HashMap<>();
        for (User i : users) {
            if (sortsUsers.containsKey(i.getAge())) {
                sortsUsers.get(i.getAge()).add(i);
            } else {
                LinkedList<User> newUser = new LinkedList<>();
                newUser.add(i);
                sortsUsers.put(i.getAge(), newUser);
            }
        }
        return sortsUsers;
    }
}
