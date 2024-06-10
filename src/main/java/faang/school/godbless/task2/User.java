package faang.school.godbless.task2;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class User {
        private static List<String> VALID_JOBS = List.of("Google", "Uber", "Amazon");
        private static List<String> VALID_ADDRESSES = List.of("London", "New York", "Amsterdam");
        private String name;
        private Integer age;
        private String workPlace;
        private String address;

        public User(String name, Integer age, String workPlace, String address) {
                if (name.isEmpty() || age < 18 || !VALID_JOBS.contains(workPlace) || !VALID_ADDRESSES.contains(address)) {
                        throw new IllegalArgumentException("Не валидные данные пользователя");
                }
                this.name = name;
                this.age = age;
                this.workPlace = workPlace;
                this.address = address;
        }

        public static Map<Integer, List<User>> groupUser(List<User> users) {
                Map<Integer, List<User>> result = new HashMap<>();
                for (User user : users) {
                        result.computeIfAbsent(user.age, k -> new ArrayList<>()).add(user);
                }
                return result;
        }
}
