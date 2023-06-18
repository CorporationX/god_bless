package faang.school.godbless.user_registration;

import java.util.*;

public class User {
        private final String name;

        private final int age;
        private final String workplace;
        private final String address;
        static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
        static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
        static final int LEGAL_AGE = 18;

        public User(String name, int age, String workplace, String address) {

            if (name.isBlank() || age < LEGAL_AGE || !VALID_JOBS.contains(workplace) || !VALID_ADDRESSES.contains(address)) {
                throw new IllegalArgumentException("Incorrect data was transmitted");
            } else {
                this.name = name;
                this.age = age;
                this.workplace = workplace;
                this.address = address;
            }
        }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map <Integer, List<User>> map = new HashMap<>();
        for (User user : users) {
            int userAge = user.getAge();
            List<User> list = map.containsKey(userAge) ? map.get(userAge) : new ArrayList<>();
            list.add(user);
            map.put(userAge, list);
        }

        return map;
    }
    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", workplace='" + workplace + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
    public int getAge() {
        return age;
    }
}