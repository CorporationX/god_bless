package school.faang.groupingByAge;


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
        if (name == null || year == null || month == null
                || day == null || job == null || address == null) {
            throw new IllegalArgumentException("Invalid arguments. Some argument is null");
        }
        this.name = name;
        this.dateOfBirth = LocalDate.of(year, month, day);
        this.job = job;
        this.address = address;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users, Integer age) {
        List<User> usersWithTargetAge = new ArrayList<>();
        Map<Integer, List<User>> groupedUsers = new HashMap<>();
        groupedUsers.put(age, usersWithTargetAge);
        LocalDate today = LocalDate.now();

        for (User user : users) {
            Period agePeriod = Period.between(user.dateOfBirth, today);
            if (agePeriod.getYears() == age) {
                groupedUsers.get(age).add(user);
            }
        }
        return groupedUsers;
    }

    @Override
    public String toString() {
        Period age = Period.between(dateOfBirth, LocalDate.now());
        return String.format("Name: %s, age: %d, job: %s, address: %s",
                name, age.getYears(), job, address);
    }
}
