package faang.school.godbless;

import lombok.Getter;

import java.util.*;

public class User {
    @Getter
    private String name;
    @Getter
    private int age;
    @Getter
    private String work;
    @Getter
    private String address;

    public User(String name, int age, String work, String address) {
        userValidate();
        this.name = name;
        this.age = age;
        this.work = work;
        this.address = address;
    }
    private void userValidate(){
        if (name!=null && !name.isEmpty()) {
            throw new IllegalArgumentException("Name can not be empty, please fill it!");
        }
        if (age < 18) {
            throw new IllegalArgumentException("Age is not valid!");
        }
        if (!VALID_JOBS.contains(work)) {
            throw new IllegalArgumentException("Work is not in the VALID_JOBS");
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Address is not in the VALID_ADDRESSES");
        }
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
        VALID_ADDRESSES.add("London");
        VALID_ADDRESSES.add("New York");
        VALID_ADDRESSES.add("Amsterdam");
    }
}
