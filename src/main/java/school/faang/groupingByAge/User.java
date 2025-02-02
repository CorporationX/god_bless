package school.faang.groupingByAge;

import lombok.Getter;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    private String name;
    private LocalDate dateOfBirth;
    private String job;
    private String address;

    public User(String name, Integer year, Integer month, Integer day, String job, String address) {
        this.name = name;
        this.dateOfBirth = LocalDate.of(year, month, day);
        this.job = job;
        this.address = address;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users, Integer age) {
        List<User> userSameDate = new ArrayList<>();
        Map<Integer, List<User>> groupedUsers = new HashMap<>();
        groupedUsers.put(age, userSameDate);
        LocalDate today = LocalDate.now();

        for (User user : users) {
            if (ChronoUnit.YEARS.between(user.dateOfBirth, today) == age) {
                groupedUsers.get(age).add(user);
            }
        }
        return groupedUsers;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Date: " + dateOfBirth.toString();
    }
}
