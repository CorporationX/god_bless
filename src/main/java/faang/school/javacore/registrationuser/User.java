package faang.school.javacore.registrationuser;


import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

@ToString
public class User {
    final String name;
    final int age;
    final String placeOfWork;
    final String address;
    static final Set valid_jobs = Set.of("Google", "Uber", "Amazon");
    static final Set valid_address = Set.of("London", "New York", "Amsterdam");

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

    private static HashMap groupUsers(List<User> listUsers) {
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
        HashMap hashMap = groupUsers(userList);
        for (Object entry : hashMap.entrySet()) {
            System.out.println(entry);
        }
    }
}



