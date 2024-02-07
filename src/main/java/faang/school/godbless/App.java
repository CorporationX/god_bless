package faang.school.godbless;

import java.util.*;
import java.util.stream.Collectors;

public class App {
    private String name;
    private int age;
    private String work;
    private String address;

    public App(String name, int age, String work, String address) {
        this.name = name;
        this.age = age;
        this.work = work;
        this.address = address;
    }

    public static final Set<String> VALID_JOBS;

    static {
        VALID_JOBS = new HashSet<>();
        VALID_JOBS.add("Google");
        VALID_JOBS.add("Uber");
        VALID_JOBS.add("Amazon");
    }

    public static final Set<String> VALID_ADDRESSES;

    static {
        VALID_ADDRESSES = new HashSet<>();
        VALID_JOBS.add("London");
        VALID_JOBS.add("New York");
        VALID_JOBS.add("Amsterdam");
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        if (age < 18) {
            throw new IllegalArgumentException("Age is not valid!");
        }
        return age;
    }

    public String getWork() {
        return work;
    }

    public String getAddress() {
        return address;
    }

    public static Map<Integer, List<App>> groupUsers(List<App> users) {
        return users.stream().collect(Collectors.groupingBy(App::getAge));
    }
}
