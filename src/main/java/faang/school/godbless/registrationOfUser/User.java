package faang.school.godbless.registrationOfUser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class User {
    private String name;
    private int age;
    private String placeOfJob;
    private String address;

    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private static final int EIGHTEEN = 18;


    public User(String name, int age, String placeOfJob, String address) {

        if (name.isBlank()) {
            throw new IllegalArgumentException("Имя не может быть пустым!");
        }
        if (age < EIGHTEEN) {
            throw new IllegalArgumentException("Возраст не может быть меньше 18!");
        }
        if (!VALID_JOBS.contains(placeOfJob)) {
            throw new IllegalArgumentException("Место работы не найдено!");
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Адрес не найден!");
        }

        this.name = name;
        this.age = age;
        this.placeOfJob = placeOfJob;
        this.address = address;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> userList) {
        Map<Integer, List<User>> mapGroupUsers = new HashMap<>();

        for (User user : userList) {
            int userAge = user.getAge();
            if (!mapGroupUsers.containsKey(userAge)) {
                mapGroupUsers.put(userAge, new ArrayList<>());
            }
            mapGroupUsers.get(userAge).add(user);
        }
        return mapGroupUsers;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPlaceOfJob() {
        return placeOfJob;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + this.name + '\'' +
                ", age=" + this.age +
                ", placeOfJob='" + this.placeOfJob + '\'' +
                ", address='" + this.address + '\'' +
                '}';
    }
}
