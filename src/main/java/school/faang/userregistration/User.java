package school.faang.userregistration;

import java.util.Set;

public class User {
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private static final int ADULT_AGE = 18;

    private final String name;
    private int age;
    private String job;
    private String address;

    public User(String name, int age, String job, String address) {
        if (name == null) {
            throw new NullPointerException("Значение имени пользователя не может быть null");
        }

        if (job == null) {
            throw new NullPointerException("Значение работы пользователя не может быть null");
        }

        if (address == null) {
            throw new NullPointerException("Значение адреса пользователя не может быть null");
        }
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }

        if (age < ADULT_AGE) {
            throw new IllegalArgumentException("Возраст не может быть меньше 18");
        }

        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Недопустимое место работы: " + job);
        }

        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Недопустимый адрес: " + address);
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

    public void setAge(int age) {
        if (age < ADULT_AGE) {
            throw new IllegalArgumentException("Возраст не может быть меньше 18");
        }
        this.age = age;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        if (job == null) {
            throw new NullPointerException("Значение работы пользователя не может быть null");
        }

        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Недопустимое место работы: " + job);
        }

        this.job = job;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if (address == null) {
            throw new NullPointerException("Значение адреса пользователя не может быть null");
        }

        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Недопустимый адрес: " + address);
        }

        this.address = address;
    }

    @Override
    public String toString() {
        return String.format("User {name=%s, age=%d, job=%s, address=%s}",
                name, age, job, address);
    }
}