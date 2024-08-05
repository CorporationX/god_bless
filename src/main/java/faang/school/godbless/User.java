package faang.school.godbless;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class User {
    private String name;
    private int age;
    private String job;
    private String adress;

    public User(String name, int age, String job, String adress) {
        this.name = name;
        this.age = age;
        this.job = job;
        this.adress = adress;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "User{" + "name='" + name + '\'' + ", age=" + age + '\'' + '}';
    }

    public static HashMap<Integer, List<User>> groupUsers(List<User> listOfUsers) throws Exception {
        HashMap<Integer, List<User>> result = new HashMap<>();
        Set<Integer> ageGroups = result.keySet();
        if (listOfUsers.isEmpty()) {
            throw new RuntimeException();
        }
        for (User user : listOfUsers) {
            if (!ageGroups.contains(user.getAge())) {
                result.put(user.getAge(), new ArrayList<>());
            }

            result.get(user.getAge()).add(user);
        }

        return result;
    }
}
