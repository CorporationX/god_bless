package faang.school.godbless.basic.users.collect;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

@Data
public class User {
    public static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    public static final Set<String> VALID_ADDRESSES = Set.of( "London", "New York", "Amsterdam");
    public static final int MIN_AGE = 18;

    private int id;
    private String name;
    private int age;
    private Set<String> hobbies;

    public User(int id, String name, int age, String jobTitle, String city) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Name can not be empty");
        }

        if (!User.VALID_JOBS.contains(jobTitle)) {
            throw new IllegalArgumentException("The " + name + " Job has to be from the following list: " + String.join(", ", User.VALID_JOBS));
        }

        if (!User.VALID_ADDRESSES.contains(city)) {
            throw new IllegalArgumentException("The " + name + " has to be from the following city: " + String.join(", ", User.VALID_ADDRESSES));
        }

        if (age < User.MIN_AGE) {
            throw new IllegalArgumentException("The " + name + " age has tobe greater than: " + User.MIN_AGE);
        }

        this.id = id;
        this.name = name;
        this.age = age;
    }

    public User(int id, String name, int age, Set<String> hobbies) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.hobbies = hobbies;
    }


    public HashMap<Integer, String> findHobbyLovers(User user, Set<String> hobbies) {
        HashMap<Integer, String> map = new HashMap<>();
            for (String hobby: hobbies) {
                if (user.hobbies.contains(hobby)) {
                    map.put(user.id, hobby);
                    return map;
                }
            }
        return map;
    }

    public static HashMap<Integer, ArrayList<User>> groupUsers(ArrayList<User> users) {
        HashMap<Integer, ArrayList<User>> map = new HashMap<>();

        for (User user: users) {
            if (map.containsKey(user.age)) {
                ArrayList<User> userEntity = map.get(user.age);
                userEntity.add(user);
                map.put(user.age, userEntity);
            } else {
                map.put(user.age, new ArrayList<>(List.of(user)));
            }
        }
        return map;
    }

    @Override
    public String toString() {
        return name;
    }
}
