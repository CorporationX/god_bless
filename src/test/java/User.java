import java.util.*;

public class User {
    private final String name;
    private final int age;
    private final String placeOfJod;
    private final String address;

    public static final Set<String> VALID_JOBS = new HashSet<>(Arrays.asList("Google", "Uber", "Amazon"));
    public static final Set<String> VALID_ADDRESSES = new HashSet<>(Arrays.asList("London", "New York", "Amsterdam"));
    public static final int AGE = 18;

    public User(String name, int age, String placeOfJod, String address) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("name is null or empty");
        }
        if (age < AGE) {
            throw new IllegalArgumentException("age can`t be less then 18");
        }
        if (!VALID_JOBS.contains(placeOfJod)) {
            throw new IllegalArgumentException("placeOfJod can be " + "Google" + "Uber" + "Amazon");
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("address can be only" + "London" + "New York" + "Amsterdam");
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

