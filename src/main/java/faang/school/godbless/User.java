package faang.school.godbless;

import lombok.Data;

import java.util.*;

@Data
public class User {
    private String userName;
    private int userAge;
    private String userPlaceWork;
    private String userAddress;

    private static final int VALID_AGE = 18;
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESS = Set.of("London", "New York", "Amsterdam");

    public User(String userName, int userAge, String userPlaceWork, String userAddress) {
        if (!(userName == null)) {
            this.userName = userName;
        } else {
            throw new IllegalArgumentException("Имя не должно быть пустым");
        }

        if (!userName.isEmpty()) {
            this.userName = userName;
        } else {
            throw new IllegalArgumentException("Имя не должно быть пустым");
        }

        if (userAge >=  VALID_AGE) {
            this.userAge = userAge;
        } else {
            throw new IllegalArgumentException("Возраст должен быть не меньше 18");
        }

        if (VALID_JOBS.contains(userPlaceWork)) {
            this.userPlaceWork = userPlaceWork;
        } else {
            throw new IllegalArgumentException("Место работы должно быть из валидного списка");
        }

        if (VALID_ADDRESS.contains(userAddress)) {
            this.userAddress = userAddress;
        } else {
            throw new IllegalArgumentException("Адресс должен быть из валидного списка");
        }
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> groupedUser= new HashMap<>();

        for (User user: users) {
            int age = user.getUserAge();

            if(!groupedUser.containsKey(age)) {
                groupedUser.put(age, new ArrayList<>());
            }

            groupedUser.get(age).add(user);
        }

        return groupedUser;
    }
}


