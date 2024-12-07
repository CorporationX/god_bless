package school.faang.userregister;

import java.util.Set;

public class User {
    String name;
    int age;
    String job;
    String address;

    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    public User(String name, int age, String job, String address) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым.");
        } else if (age < 18) {
            throw new IllegalArgumentException("Возраст не может быть меньше 18.");
        } else if (!VALID_JOBS.contains(job)) {

            throw new IllegalArgumentException("Место работы должно быть содержится в наборе VALID_JOBS.");
        } else if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Адрес должен быть содержится в наборе VALID_ADDRESSES.");
        }
        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым.");
        }
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 18) {
            throw new IllegalArgumentException("Возраст не может быть меньше 18.");
        }
        this.age = age;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Место работы должно быть содержится в наборе VALID_JOBS.");
        }
        this.job = job;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Адрес должен быть содержится в наборе VALID_ADDRESSES.");
        }
        this.address = address;
    }
}
