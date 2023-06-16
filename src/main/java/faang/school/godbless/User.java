package faang.school.godbless;

import java.util.*;

public class User {
    private String name;
    private int age;
    private String workplace;
    private String address;

    public int getAge() {
        return age;
    }

    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private static final int MIN_WORKING_AGE = 18;

    public User(String name, int age, String workplace, String address) {

        if (name.isEmpty()) {
            throw new IllegalArgumentException("Поле Имя не может быть пустым");
        }
        if (age < MIN_WORKING_AGE) {
            throw new IllegalArgumentException("Возраст не может быть меньше 18");
        }
        if (!VALID_JOBS.contains(workplace)) {
            throw new IllegalArgumentException("Место работы не может быть: " + workplace);
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Адрес не может быть: " + address);
        }

        this.name = name;
        this.age = age;
        this.workplace = workplace;
        this.address = address;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> userList) {
        Map<Integer, List<User>> groupedUserMap = new HashMap<>();
        for (User user : userList) {
            int age = user.getAge();
            if (!groupedUserMap.containsKey(age)) {
                groupedUserMap.put(age, new ArrayList<>());
            }
            groupedUserMap.get(age).add(user);
        }
        return groupedUserMap;
    }
}





