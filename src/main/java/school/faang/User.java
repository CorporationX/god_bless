package school.faang;

<<<<<<< boby808-BJS2-56436
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
=======
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
>>>>>>> boby808

@Slf4j
@ToString
@Getter
@EqualsAndHashCode
public class User {
    private final String name;
    private final int age;
<<<<<<< boby808-BJS2-56436
    private final String job;
    private final String address;

    public static final Set<String> VALID_JOBS;
    public static final Set<String> VALID_ADDRESSES;
    public static final int MIN_AGE = 18;

    static {
        VALID_JOBS = Set.of("Google", "Uber", "Amazon");
        VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    }

    public User(String name, int age, String job, String address) {
        this.age = age;
        this.job = job;
        this.address = address;
        this.name = name;

        if (age < MIN_AGE) {
            throw new IllegalArgumentException("Age cannot be less than " + MIN_AGE + "! Age " + age);
        }
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be blank!");
        }
        if (job == null || !VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Invalid job! Job " + job + " is not valid!");
        }
        if (address == null || !VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Invalid address! Address " + address + " is not valid!");
        }

    }

    public static void main(String[] args) {
        User bob = new User("Bob", 19, "Google", "New York");
        User nate = new User("Nate", 21, "Amazon", "London");
        List<User> users = new ArrayList(List.of(bob, nate));
        System.out.println(users);
    }

    @Override
    public String toString() {
        return String.format("User: {name=%s, age='%d', job=%s, address=%s}", name, age, job, address);
    }

    public String getName() {
        return name;
    }
=======
    private final String work;
    private final String address;

    public User(String name, int age, String work, String address) {
        this.name = name;
        this.age = age;
        this.work = work;
        this.address = address;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> map = new HashMap<>();
        for (User user : users) {
            if (isValidUser(user)) {
                if (!map.containsKey(user.getAge())) {
                    map.put(user.getAge(), new ArrayList<>());
                }
                map.get(user.getAge()).add(user);
            } else {
                log.info(" Invalid user skipped {}", user);
            }
        }
        return map;
    }

    public static boolean isValidUser(User user) {
        return user != null && !user.getName().isBlank() && !user.getAddress().isBlank()
                && !user.getWork().isBlank() && user.getAge() >= 0;

>>>>>>> boby808

    }

<<<<<<< boby808-BJS2-56436
    public String getJob() {
        return job;
    }

    public String getAddress() {
        return address;
    }

=======
    public static void main(String[] args) {
        User user1 = new User("Tom", 25, "Bum", "New York");
        User user2 = new User("Sarah", 13, "Builder", "");
        User user3 = new User("John", 48, "Engineer", "Moscow");
        User user4 = new User("Kukan", 25, "Bum", "New York");
        User user5 = new User("Lena", 13, "Builder", "Paris");
        List<User> list = new ArrayList<>(List.of(user1, user2, user3, user4, user5));
        System.out.println(groupUsers(list));
    }
>>>>>>> boby808
}

