package school.faang.BJS243647;

import java.util.Set;

public class User {

    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESS = Set.of("London", "New York", "Amsterdam");
    private static final int LIMIT = 18;

    private String name;
    private int age;
    private String job;
    private String address;


    public User(String name, int age, String job, String address) {
        checkName(name);
        checkAge(age);
        checkJob(job);
        checkAddress(address);

        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;


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


    private void checkName(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Имя не должно быть пустым.");
        }
    }

    private void checkAge(int age) {
        if (age < LIMIT) {
            throw new IllegalArgumentException(String.format("Возраст должен быть больше %d", LIMIT));
        }
    }

    private void checkJob(String job) {
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Работа должна находиться в заданном множестве");
        }
    }

    private void checkAddress(String address) {
        if (!VALID_ADDRESS.contains(address)) {
            throw new IllegalArgumentException("Адрес должен находиться в заданном множестве");
        }
    }


}
