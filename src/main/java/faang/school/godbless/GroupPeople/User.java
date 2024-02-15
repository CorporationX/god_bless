package faang.school.godbless.GroupPeople;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class User {

    private String name;
    private int age;
    private String company;
    private String adress;
    private static final int VALID_AGE = 18;
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    public User(String name, int age, String company, String adress) {
        areParametersValid(name, age, company, adress);
        this.name = name;
        this.age = age;
        this.company = company;
        this.adress = adress;
    }

    public static Map<Integer, List<User>> groupUser(List<User> usersList) {
        Map<Integer, List<User>> groupedUsers = new HashMap<>();

        for (User user : usersList) {
            if (!(groupedUsers.containsKey(user.age))) {
                groupedUsers.put(user.age, new ArrayList<>());
            }
            groupedUsers.get(user.age).add(user);
        }
        return groupedUsers;
    }

    private void areParametersValid(String name, int age, String company, String adress) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Name не может быть пустым.");
        }
        if (age < VALID_AGE) {
            throw new IllegalArgumentException("Возраст не может быть меньше 18.");
        }
        if (!(VALID_JOBS.contains(company))) {
            throw new IllegalArgumentException("Нельзя работать нигде, кроме Google, Uber или Amazon (извини).");
        }
        if (!(VALID_ADDRESSES.contains(adress))) {
            throw new IllegalArgumentException("Нельзя жить нигде, кроме London, New York или Amsterdam (такая жизнь)");
        }
    }
}