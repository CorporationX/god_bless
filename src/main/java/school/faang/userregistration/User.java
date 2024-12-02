package school.faang.userregistration;

import java.util.*;

public class User {
    public static final Set<String> VALID_JOBS = new HashSet<>(Arrays.asList("Google", "Uber", "Amazon"));
    public static final Set<String> VALID_ADDRESSES = new HashSet<>(Arrays.asList("London", "New York", "Amsterdam"));
    public static final int MIN_AGE = 18;

    private String name;
    private int age;
    private String job;
    private String address;

    public User(String name, int age, String job, String address) {
        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("The name cannot be empty");
        }
        this.name = name;
    }

    public void setAge(int age) {
        if (age >= 18) {
            this.age = age;
        } else {
            throw new IllegalArgumentException("The age cannot be less than 18");
        }
    }

    public void setJob(String job) {
        if (VALID_JOBS.contains(job)) {
            this.job = job;
        } else {
            throw new IllegalArgumentException("The place of work must be contained in the VALID_JOBS");
        }
    }

    public void setAddress(String address) {
        if (VALID_ADDRESSES.contains(address)) {
            this.address = address;
        } else {
            throw new IllegalArgumentException("The address must be contained in the set VALID_ADDRESSES");
        }
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getJob() {
        return job;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        User user = (User) object;
        return age == user.age
                && Objects.equals(name, user.name)
                && Objects.equals(job, user.job)
                && Objects.equals(address, user.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, job, address);
    }


}
