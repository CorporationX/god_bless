package faang.school.javacore.registrationuser;

import lombok.ToString;

import java.util.*;

@ToString
public class User {
    private final String name;
    private final int age;
    private final String placeOfWork;
    private final String address;
    private static final Set<String> valid_jobs = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> valid_address = Set.of("London", "New York", "Amsterdam");

    public User(String name, int age, String placeOfWork, String address) {
        this.name = name;
        this.age = age;
        this.placeOfWork = placeOfWork;
        this.address = address;

    }

    private static void validUser(User user) {
        if (user.name.isBlank()
                || user.age < 18
                || !(valid_jobs.contains(user.placeOfWork))
                || !(valid_address.contains(user.address))) {
            throw new IllegalArgumentException();
        }
    }

    private static HashMap<Integer, List<User>> groupUsers(List<User> listUsers) {
        HashMap<Integer, List<User>> hashMapUsers = new HashMap<>();
        for (User user : listUsers) {
            validUser(user);
            hashMapUsers.computeIfAbsent(user.age, k -> new ArrayList<>()).add(user);
        }
        return hashMapUsers;
    }

    public static void main(String[] args) {
        List<User> userList = new ArrayList<>();
        userList.add(new User("Alex", 22, "Google", "Amsterdam"));
        userList.add(new User("Oleg", 11, "Google", "Amsterdam"));
        userList.add(new User("Max", 22, "Google", "Amsterdam"));
        HashMap<Integer, List<User>> mapUser = groupUsers(userList);
        for (Map.Entry user : mapUser.entrySet()) {
            System.out.println(user);
        }
    }
}



