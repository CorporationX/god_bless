package faang.school.javacore.registrationuser;

import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

@ToString
public class User {
    private String name;
    private int age;
    private String placeOfWork;
    private String address;
    private static final Set valid_jobs = Set.of("Google", "Uber", "Amazon");
    private static final Set valid_address = Set.of("London", "New York", "Amsterdam");

    public User(String name, int age, String placeOfWork, String address) {
        if (name.isBlank() || age < 18 || !(valid_jobs.contains(placeOfWork)) || !(valid_address.contains(address))) {
            throw new IllegalArgumentException();
        } else {
            this.name = name;
            this.age = age;
            this.placeOfWork = placeOfWork;
            this.address = address;
        }
    }

    static HashMap groupUsers(List<User> listUsers) {
        HashMap<Integer, List<User>> hashMapUsers = new HashMap<>();
        for (User user : listUsers) {
            if (!(hashMapUsers.containsKey(user.age))) {
                hashMapUsers.put(user.age, new ArrayList<>());
            }
            hashMapUsers.get(user.age).add(user);
        }
        return hashMapUsers;
    }
}



