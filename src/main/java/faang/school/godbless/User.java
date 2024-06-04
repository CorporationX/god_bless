package faang.school.godbless;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Getter
@Setter
@ToString
public class User {

    private String name;

    @Getter
    @Setter
    private int age;

    private String placeOfWork;

    private String adress;

    private final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");

    private final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    public User(String name, int age, String placeOfWork, String adress) {
        if (isValidUser(name, age, placeOfWork, adress)) {
            this.name = name;
            this.age = age;
            this.placeOfWork = placeOfWork;
            this.adress = adress;
        } else throw new IllegalArgumentException("invalid user");
    }

    private boolean isValidUser(String name, int age, String placeOfWork, String adress) {
        return (!name.isEmpty() && age > 17 && VALID_JOBS.contains(placeOfWork) && VALID_ADDRESSES.contains(adress));
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> mapUser = new HashMap<>();

        for (User user : users) {

            List<User> users1 = mapUser.get(user.getAge());
            if (users1 != null) {
                users1.add(user);
            } else {
                List<User> newUsers = new ArrayList<>();
                newUsers.add(user);
                mapUser.put(user.getAge(), newUsers);
            }

        }

        return mapUser;
    }


}
