package faang.school.godbless;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class User {
    private String name, placeOfWork, address;
    private int age;
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");


    public User(String name, String placeOfWork, String address, int age) {
        if (name.isEmpty() || age < 18 || !VALID_ADDRESSES.contains(address) || !VALID_JOBS.contains(placeOfWork)) {
            throw new IllegalArgumentException();
        }
            this.name = name;
            this.age = age;
            this.address = address;
            this.placeOfWork = placeOfWork;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", placeOfWork='" + placeOfWork + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                '}';
    }

    public int getAge() {
        return age;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> map = new HashMap<>();

        for (User user : users) {
            if (map.containsKey(user.getAge())) {
                map.get(user.getAge()).add(user);
            } else {
                List<User> newListUsers = new ArrayList<>();
                newListUsers.add(user);
                map.put(user.getAge(), newListUsers);
            }
        }
        return map;
    }

//  Тестовая функция для проверки.
    public static void readingMap(Map<Integer, List<User>> map) {
        for (Map.Entry<Integer, List<User>> pair : map.entrySet()) {
            Integer key = pair.getKey();
            List<User> users = pair.getValue();
            System.out.println(key);

            for (User user : users) {
                System.out.println(user);
            }
        }
    }
}
