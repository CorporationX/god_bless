package faang.school.godbless.registration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class User {
    private String name;
    private int age;
    private String work;
    private String adress;

    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    public User(String name, Integer age, String work, String adress) throws IllegalArgumentException {

        if ((name.isBlank()) || (age < 18) || (!VALID_JOBS.contains(work)) || (!VALID_ADDRESSES.contains(adress))) {
          throw new IllegalArgumentException("Warning! check data entry!");
        } else {
            this.name = name;
            this.age = age;
            this.work = work;
            this.adress = adress;
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", work='" + work + '\'' +
                ", adress='" + adress + '\'' +
                '}';
    }

    public static Map<Integer, List<User>> groupUsers(List<User> listUser) {

        Map<Integer, List<User>> usersGroup = new HashMap<>();
        for (User user : listUser) {
            if (!usersGroup.containsKey(user.age)) {
                usersGroup.put(user.age, new ArrayList<>());
            }
            usersGroup.get(user.age).add(user);
        }
        return usersGroup;
    }
}
