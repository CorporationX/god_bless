package school.faang.users_registration;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

@Getter
public class User {
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    private String userName;
    private int userAge;
    private String placeOfWork;
    private String address;

    public User(String userName, int userAge, String placeOfWork, String address) {
        if (userName == null || userName.isBlank()) {
            throw new IllegalArgumentException("User cannot be empty");
        }

        if (userAge < 18) {
            throw new IllegalArgumentException("The user must be at least 18 years old");
        }

        if (!VALID_JOBS.contains(placeOfWork)) {
            throw new IllegalArgumentException("Invalid place of work");
        }

        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Invalid address");
        }
        this.userName = userName;
        this.userAge = userAge;
        this.placeOfWork = placeOfWork;
        this.address = address;
    }

    public static HashMap<Integer, ArrayList<User>> groupUsers(List<User> users) {
        HashMap<Integer, ArrayList<User>> gropedUsers = new HashMap<>();
        for (User user : users) {
            gropedUsers.computeIfAbsent(user.getUserAge(), age -> new ArrayList<>()).add(user);
        }
        return gropedUsers;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                '}';
    }
}