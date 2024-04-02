package faang.school.godbless.BJS2_4122.models;

import faang.school.godbless.BJS2_4122.enums.Address;
import faang.school.godbless.BJS2_4122.enums.Job;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Getter
@Setter
public class User {
    private String name;
    private byte age;
    private Job job;
    private Address address;

    private static final Set<Job> VALID_JOBS = new HashSet<>(Set.of(Job.GOOGLE, Job.UBER, Job.AMAZON));
    private static final Set<Address> VALID_ADDRESSES = new HashSet<>(Set.of(Address.LONDON, Address.NEW_YORK, Address.AMSTERDAM));

    public User(String name, byte age, Job job, Address address) {
        this.setName(name);
        this.setAge(age);
        this.setJob(job);
        this.setAddress(address);
    }

    public void  setJob(Job job) {
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Invalid value for job: " + job);
        }

        this.job = job;
    }

    public void  setAddress(Address address) {
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Invalid value for address: " + address);
        }

        this.address = address;
    }

    public void  setAge(Byte age) {
        if (age < 18) {
            throw new IllegalArgumentException("The age must be at least 18");
        }

        this.age = age;
    }

    public void  setName(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("The name cannot be empty!");
        }

        this.name = name;
    }

    public static Map<Byte, List<User>> groupUsersByAge(List<User> users) {
        Map<Byte, List<User>> result = new HashMap<>();

        for (User user : users) {
            result.computeIfAbsent(user.getAge(), k -> new ArrayList<>()).add(user);
        }

        return result;
    }
}
