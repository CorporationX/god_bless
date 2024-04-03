package faang.school.godbless.BJS2_4122.models;

import faang.school.godbless.BJS2_4122.enums.Address;
import faang.school.godbless.BJS2_4122.enums.Job;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Getter
public class User {
    private static final int AGE_MAJORITY = 18;
    private static final Set<Job> VALID_JOBS = Set.of(Job.GOOGLE, Job.UBER, Job.AMAZON);
    private static final Set<Address> VALID_ADDRESSES = Set.of(Address.LONDON, Address.NEW_YORK, Address.AMSTERDAM);

    private String name;
    private int age;
    private Job job;
    private Address address;

    public User(String name, int age, Job job, Address address) {
        this.setName(name);
        this.setAge(age);
        this.setJob(job);
        this.setAddress(address);
    }

    public void setJob(Job job) {
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Invalid value for job: " + job);
        }

        this.job = job;
    }

    public void setAddress(Address address) {
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Invalid value for address: " + address);
        }

        this.address = address;
    }

    public void setAge(int age) {
        if (age < AGE_MAJORITY) {
            throw new IllegalArgumentException("The age must be at least 18");
        }

        this.age = age;
    }

    public void setName(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("The name cannot be empty!");
        }

        this.name = name;
    }

    public static Map<Integer, List<User>> groupUsersByAge(List<User> users) {
        Map<Integer, List<User>> result = new HashMap<>();

        for (User user : users) {
            result.computeIfAbsent(user.getAge(), k -> new ArrayList<>()).add(user);
        }

        return result;
    }
}
