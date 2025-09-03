package school.faang.bjs2_85533;

import lombok.Getter;

import java.util.List;
import java.util.Objects;
import java.util.Set;

@Getter
public class User {
    private static final List<String> VALID_JOB = List.of("Google", "Uber", "Amazon");
    private static final List<String> VALID_ADDRESSES = List.of("London", "New York", "Amsterdam");

    private String name;
    private int age;
    private String job;
    private String address;

    public User(String name, int age, String job, String address) throws IllegalArgumentException {
        if (name.isBlank()) {
            throw new IllegalArgumentException("name is null");
        } else {
            this.name = name;
        }

        if (age < 18) {
            throw new IllegalArgumentException("age under 18");
        } else {
            this.age = age;
        }

        if (!VALID_JOB.contains(job)) {
            throw new IllegalArgumentException("there is no such work");
        } else {
            this.job = job;

        }

        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("no such address");
        } else {
            this.address = address;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return age == user.age && Objects.equals(name, user.name)
                && Objects.equals(job, user.job)
                && Objects.equals(address, user.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, job, address);
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
