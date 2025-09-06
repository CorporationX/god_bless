package school.faang.bjs2_85571;

import java.util.Set;

public class User {
    public static final Set<String> VALID_JOB = Set.of("Google", "Uber", "Amazon");
    public static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    public static int MIN_AGE = 18;

    private String name;
    private int age;
    private String job;
    private String address;

    public User(String name, int age, String job, String address) {
        if (name != null && !name.isBlank()) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Имя не должно быть пустым");
        }
        if (age >= MIN_AGE) {
            this.age = age;
        } else {
            throw new IllegalArgumentException("Пользователю должно быть не менее 18 лет");
        }
        if (VALID_JOB.contains(job)) {
            this.job = job;
        } else {
            throw new IllegalArgumentException("Допустимое место работы: Google, Uber или Amazon");
        }
        if (VALID_ADDRESSES.contains(address)) {
            this.address = address;
        } else {
            throw new IllegalArgumentException("Допустимый адрес: London, New York или Amsterdam");
        }
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
