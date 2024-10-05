package school.faang;

import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
public class User {
    private static Set<String> VALID_JOBS = new HashSet<>(Arrays.asList("Google", "Uber", "Amazon"));
    private static Set<String> VALID_ADDRESSES = new HashSet<>(Arrays.asList("London", "New York", "Amsterdam"));
    private String name;
    private String age;
    private String job;
    private String address;

    private void Validation(String name, String age, String job, String address) throws IllegalArgumentException {
        if (name.equals("")) throw new IllegalArgumentException("Uncorrected name");
        if ((Integer.parseInt(age) < 18) || (Integer.parseInt(age) > 100))
            throw new IllegalArgumentException("Uncorrected age");
        if (!VALID_JOBS.contains(job))
            throw new IllegalArgumentException("Uncorrected job");
        if (!VALID_ADDRESSES.contains(address))
            throw new IllegalArgumentException("Uncorrected address");
    }

    public User(String name, String age, String job, String address) {
        try {
            Validation(name, age, job, address);
            this.name = name;
            this.age = age;
            this.job = job;
            this.address = address;
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }

    public static Map<String, List<User>> groupUsers(List<User> users) {
        Map<String, List<User>> mapByAge = new HashMap<>();
        for (User user : users) {
            mapByAge.computeIfAbsent(user.age, k -> new ArrayList<>()).add(user);
        }
        return mapByAge;
    }

}

