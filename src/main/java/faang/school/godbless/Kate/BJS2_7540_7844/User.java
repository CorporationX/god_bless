package faang.school.godbless.Kate.BJS2_7540_7844;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class User {
    private String name;
    private int age;
    private String job;
    private String address;

    private Set<String> VALID_JOBS = new HashSet<>(Arrays.asList("Google", "Uber", "Amazon"));

    private Set<String> VALID_ADDRESSES = new HashSet<>(Arrays.asList("London", "NY", "Amsterdam"));

    public static ArrayList<User> users = new ArrayList<>();

    public User(String name, int age, String job, String address) {
        try {
            if (name.isEmpty() || age<18 || !(VALID_JOBS.contains(job)) ||
                    !(VALID_ADDRESSES.contains(address))) {
                System.out.println("ошибка ввода");
                throw new IllegalArgumentException();
            }
            this.name = name;
            this.age = age;
            this.job = job;
            this.address = address;
            users.add(this);
        }  catch (IllegalArgumentException e) {
        return;
    }
    }

    public int getAge() {
        return age;
    }

    public static HashMap<Integer, ArrayList<User>> groupUsers(ArrayList<User> users) {
        int k;
        HashMap<Integer, ArrayList<User>> sort = new HashMap<>();
        for (User user : users) {
            k = user.getAge();
            ArrayList<User> group = new ArrayList<>();
            if (sort.containsKey(k)) {
                sort.get(k).add(user);
            } else {
                group.add(user);
                sort.put(k, group);
            }
        }
        return sort;
    }

}






