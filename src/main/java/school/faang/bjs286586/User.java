package school.faang.bjs286586;

import java.util.Objects;
import java.util.Set;

public class User {
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");


    private final String name;
    private final int age;
    private final String job;
    private final String address;

    public User(String name, int age, String job, String address) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Name can`t be empty: " + name);
        } else if (age < 18) {
            throw new IllegalArgumentException("Age can`t be under 18: " + age);
        } else if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Job have to be in list of VALID_JOBS: " + job);
        } else if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Address have to be in list of VALID_ADDRESSES: " + address);
        }
        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
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
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof User user)) {
            return false;
        }
        return getAge() == user.getAge() && Objects.equals(getName(), user.getName()) && Objects.equals(getJob(),
                user.getJob()) && Objects.equals(getAddress(), user.getAddress());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAge(), getJob(), getAddress());
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", job='" + job + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
