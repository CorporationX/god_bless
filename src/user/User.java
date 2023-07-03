package user;

import java.util.*;

public class User {
        private String name;
        private int age;
        private String job;
        private String address;
        private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
        private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

        public User(String name, int age, String job, String address) {
            this.name = name;
            this.age = age;
            this.job = job;
            this.address = address;

            checkUser(this);
        }

    public void checkUser(User user) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be empty!");
        }
        if (age < 18) {
            throw new IllegalArgumentException("Age cannot be less than 18!");
        }
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Invalid job!");
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Invalid address!");
        }
    }
  
    public int getAge() {
        return age;
    }
  
    public static Map<Integer, List<User>> registrationUser(List<User> usersList) {
        Map<Integer, List<User>> registrationUsers = new HashMap<>();
        for (User user : usersList) {
            registrationUsers.computeIfAbsent(user.getAge(), e -> new ArrayList<>()).add(user);
        }
        return registrationUsers;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", job='" + job + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
