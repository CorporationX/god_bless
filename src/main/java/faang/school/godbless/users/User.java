package faang.school.godbless.users;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;


@Getter
@Setter
public class User {
    public static Set<String> VALID_JOBS = new HashSet<>() {{
        add("Google");
        add("Uber");
        add("Amazon");
    }};

    public static Set<String> VALID_ADDRESSES = new HashSet<>() {{
        add("London");
        add("New York");
        add("Amsterdam");
    }};

    private int id;
    private String name;
    private int age;
    private Set<String> activity;
    private String address;
    private String placeOfWork;


    public User(int id, String name, int age, Set<String> activity, String address, String placeOfWork) {
        this.id = id;
        if (Objects.isNull(name)) {
            throw new IllegalArgumentException("Field name must be not null!");
        } else {
            this.name = name;
        }

        if (age < 18) {
            throw new IllegalArgumentException("Age must be less 18 year!");
        } else {
            this.age = age;
        }

        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException(
                    "Еhe address must contain one of the following cities: " +
                            "London, New York, Amsterdam."
            );
        } else {
            this.address = address;
        }

        if (!VALID_JOBS.contains(placeOfWork)) {
            throw new IllegalArgumentException(
                    "The place of work must be one of the companies: " +
                            "Google, Uber, Amazon"
            );
        } else {
            this.placeOfWork = placeOfWork;
        }
    }

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> activities) {
        Map<User, String> hm = new HashMap<>();

        for (User user : users) {
            Set<String> userActivity = user.getActivity();
            Set<String> intersection = new HashSet<>(activities);
            intersection.retainAll(userActivity);
            if (!intersection.isEmpty()) {
                hm.put(user, intersection.stream().findFirst().get());
            }
        }
        return hm;
    }
}

