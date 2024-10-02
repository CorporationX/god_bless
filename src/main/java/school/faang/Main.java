package school.faang;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public class User {
        private static final int LEGAL_AGE = 18;
        private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
        private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
        private String name;
        private Integer age;
        private String job;
        private String address;

        public User(String name, Integer age, String job, String address) {
            if (name.isEmpty() || name == null) {
                throw new IllegalArgumentException("Имя не должно быть пустым");
            }
            if (age < LEGAL_AGE) {
                throw new IllegalArgumentException("Возраст должен быть больше 18");
            }
            if (!VALID_JOBS.contains(job)) {
                throw new IllegalArgumentException("Место работы должно содержаться во множесте VALID_JOBS");
            }
            if (!VALID_ADDRESSES.contains(address)) {
                throw new IllegalArgumentException("Адрес должен содержаться во множестве VALID_ADDRESSES");
            }
            this.name = name;
            this.age = age;
            this.job = job;
            this.address = address;
        }

        public static Map<Integer, List<User>> groupUsers(List<User> usersList) {
            Map<Integer, List<User>> usersMap = new HashMap<>();

            for(User user : usersList) {
                usersMap.computeIfAbsent(user.age, u -> new ArrayList<>()).add(user);
            }
            return usersMap;
        }
    }
}