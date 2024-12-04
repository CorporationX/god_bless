package school.faang.task43709;

import lombok.Getter;

import java.util.Set;

@Getter
public class User {
    @Getter
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private static final int MIN_AGE_USER = 18;
    private String name;
    private int age;
    private String job;
    private String address;

    public User(String name, int age, String job, String address) throws IllegalArgumentException {
        try {
            validationUsers(name, age, job, address);
            this.name = name;
            this.age = age;
            this.job = job;
            this.address = address;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void validationUsers(String userName, int userAge, String userJob, String userAddress)
            throws IllegalArgumentException {
        if (userName.isEmpty() || userName == null) {
            throw new IllegalArgumentException("Имя должно содержать строчное значение");
        }
        if (userAge < MIN_AGE_USER) {
            throw new IllegalArgumentException("Возраст не может быть меньше 18 лет!");
        }
        if (!VALID_JOBS.contains(userJob)) {
            throw new IllegalArgumentException("Не верное место работы!");
        }
        if (!VALID_ADDRESSES.contains(userAddress)) {
            throw new IllegalArgumentException("Не верный адрес!");
        }
    }
}

