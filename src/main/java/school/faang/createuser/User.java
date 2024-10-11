package school.faang.createuser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class User {
    public static final Set<String> VALID_JOBS = new HashSet<>(Arrays.asList("Google", "Uber", "Amazon"));
    public static final Set<String> VALID_ADDRESSES = new HashSet<>(Arrays.asList("London", "New York", "Amsterdam"));
    public static final int AGE = 18;

    private final String name;
    private final int age;
    private final String placeOfJod;
    private final String address;


    public User(String name, int age, String placeOfJod, String address) {
        if (name == null || name.isEmpty()
                || (age < AGE)
                || (!VALID_JOBS.contains(placeOfJod))
                || (!VALID_ADDRESSES.contains(address))) {
            throw new IllegalArgumentException("This is IllegalArgumentException");
        }

        this.name = name;
        this.age = age;
        this.placeOfJod = placeOfJod;
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age && Objects.equals(name, user.name) && Objects.equals(placeOfJod, user.placeOfJod) && Objects.equals(address, user.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, placeOfJod, address);
    }

    public Integer getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", placeOfJod='" + placeOfJod + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        HashMap<Integer, List<User>> usersmap = new HashMap<>();
        for (User user : users) {
            usersmap.computeIfAbsent(user.getAge(), k -> new ArrayList<>()).add(user);
        }
        return usersmap;
    }
}

