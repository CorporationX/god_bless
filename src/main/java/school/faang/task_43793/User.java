package school.faang.task_43793;

import java.util.Set;

public class User {
    private String name;
    private int age;
    private String job;
    private String address;

    public static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    public static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    public User(String name, int age, String job, String address) {
        setName(name);
        setAge(age);
        setJob(job);
        setAddress(address);
    }

    @Override
    public String toString() {
        return "User{Name = " + name + ", Age = " + age + ", Job = " + job + ", Address = " + address + "}";
    }

    public void setName(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("The name can't be empty!");
        }
        this.name = name;
    }

    public void setAge(int age) {
        if (age < 18) {
            throw new IllegalArgumentException("Age can't be less than 18!");
        }
        this.age = age;
    }

    public void setJob(String job) {
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Your workplace is not suitable for registration");
        }
        this.job = job;
    }

    public void setAddress(String address) {
        if (!VALID_ADDRESSES.contains((address))) {
            throw new IllegalArgumentException("The address is wrong");
        }
        this.address = address;
    }
}
