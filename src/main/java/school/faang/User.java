package school.faang;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Getter
@ToString
public class User {
    public static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    public static final Set<String> VALID_ADDRESSES = Set.of("London",
            "New York", "Amsterdam");
    public static final int VALID_AGE = 18;
    private int age;
    private String name;
    private String workPlace;
    private String address;

    User(int age, String name, String workPlace, String address) {
        this.age = age;
        this.name = name;
        this.workPlace = workPlace;
        this.address = address;

        if (this.name == null || this.name.isEmpty()) {
            throw new IllegalArgumentException("Name can't be empty");
        }
        if (this.age < VALID_AGE) {
            throw new IllegalArgumentException("Age can't be less then 18");
        }
        if (!(VALID_JOBS.contains(this.workPlace))) {
            throw new IllegalArgumentException("You have a wrong work");
        }
        if (!(VALID_ADDRESSES.contains(this.address))) {
            throw new IllegalArgumentException("You have a wrong address");
        }
    }


    public static Map<Integer, List<User>> groupUsers(List<User> startList) {
        Map<Integer, List<User>> finalMap = new HashMap<>();
        for (var user : startList) {
            List<User> sortedList = finalMap.getOrDefault(user.getAge(), new ArrayList<>());
            sortedList.add(user);
            finalMap.put(user.getAge(), sortedList);
        }

        for (Map.Entry<Integer, List<User>> entryPair : finalMap.entrySet()) {
            System.out.println(entryPair.toString());
        }
        return finalMap;
    }

    public static void main(String[] args) {
        List<User> startList = new ArrayList<>();
        try {
            startList.add(new User(25, "Bob", "Google", "London"));
            startList.add(new User(46, "Thomas", "Uber", "New York"));
            startList.add(new User(25, "Carl", "Amazon", "Amsterdam"));
            startList.add(new User(17, "Marie", "Amazon", "London"));
        } catch (IllegalArgumentException exceptionObject) {
            System.out.println("Ошибка: " + exceptionObject.getMessage());
        }

        groupUsers(startList);
    }
}