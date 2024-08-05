package faang.school.godbless;
import java.util.*;
import lombok.Getter;

public class User {
    private String name;
    private int age;
    private String workplace;
    private String address;


    // Static constants
    public static final Set<String> VALID_JOBS = new HashSet<>(Arrays.asList("Google", "Uber", "Amazon"));
    public static final Set<String> VALID_ADDRESSES = new HashSet<>(Arrays.asList("London", "New York", "Amsterdam"));


    //Validation
    public User(String name, int age, String workplace, String address) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        if (age < 18) {
            throw new IllegalArgumentException("Age must be at least 18");
        }
        if (!VALID_JOBS.contains(workplace)) {
            throw new IllegalArgumentException("Workplace must be one of " + VALID_JOBS);
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Address must be one of " + VALID_ADDRESSES);
        }
        this.name = name;
        this.age = age;
        this.workplace = workplace;
        this.address = address;
    }

@Override
public String toString() {
    return "User{" +
            "name='" + name + '\'' +
            ", age=" + age +
            ", workplace='" + workplace + '\'' +
            ", address='" + address + '\'' +
            '}';
}

// test Main
public static void main(String[] args) {
    try {
        User user1 = new User("Alice", 25, "Google", "London");
        System.out.println(user1);

        // Error main test
        User user2 = new User("", 17, "Facebook", "Paris");
        System.out.println(user2);
    } catch (IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }
}
}