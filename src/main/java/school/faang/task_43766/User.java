package school.faang.task_43766;

import java.util.Set;

public class User {
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private String name;
    private int age;
    private String job;
    private String address;

    public User(String name, int age, String job, String address) throws IllegalArgumentException {

        if (name.isEmpty()) {
            throw new IllegalArgumentException("Имя не должен быть пустым");
        }
        if (age < 18) {
            throw new IllegalArgumentException("Возраст не может быть меньше 18");
        }
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Не допустимое место работы");
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Не допустимый адрес");
        }

        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }


    @Override
    public String toString() {
        return "User{"
                +
                "name='"
                +
                name
                +
                '\''
                +
                ", age="
                +
                age
                +
                ", job='"
                +
                job
                +
                '\''
                +
                ", address='" + address
                +
                '\''
                +
                '}';
    }
}
