package school.faang.task43709;

import lombok.Getter;

import java.util.Set;

@Getter
public class User {
    private String name;
    private int age;
    private String job;
    private String address;
    static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    public User(String name, int age, String job, String address) throws IllegalArgumentException {

        try {
            if (name.isEmpty() || name == null) {
                throw new IllegalArgumentException("Имя должно содержать строчное значение!");
            } else {
                this.name = name;
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            if (age < 18) {
                throw new IllegalArgumentException("Возраст не может быть меньше 18 лет!");
            }
            this.age = age;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            if (!VALID_JOBS.contains(job)) {
                throw new IllegalArgumentException("Не верное место работы!");
            }
            this.job = job;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            if (!VALID_ADDRESSES.contains(address)) {
                throw new IllegalArgumentException("Не верный адрес!");
            }
            this.address = address;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}

