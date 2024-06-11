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
        if (name.isEmpty()) {
            System.out.println("Имя не должно быть пустым");
            throw new IllegalArgumentException();
        } else if (age < 18) {
            System.out.println("Возраст меньше 18");
            throw new IllegalArgumentException();
        } else if (!(VALID_JOBS.contains(job))) {
            System.out.println("Место работы не входит в список обрабатываемых");
            throw new IllegalArgumentException();
        } else if (!(VALID_ADDRESSES.contains(address))) {
            System.out.println("Адрес не входит в список обрабатываемых");
            throw new IllegalArgumentException();
        } else {
            this.name = name;
            this.age = age;
            this.job = job;
            this.address = address;
            users.add(this);
        }
    }

    public int getAge() {
        return this.age;
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