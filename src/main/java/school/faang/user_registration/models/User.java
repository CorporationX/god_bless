package school.faang.user_registration.models;

import lombok.Getter;

public class User {
    @Getter
    private String name;
    private int age;
    private String job;
    private String address;

    public static final int AGE_LIMIT = 18;
    public static final String[] VALID_JOBS = {"Google", "Uber", "Amazon"};
    public static final String[] VALID_ADDRESSES = {"London", "New York", "Amsterdam"};

    public User() {}

    public User(String name, int age, String job, String address) {
        validateName(name);
        validateAge(age);
        validateJob(job);
        validateAddress(address);

        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }

    private void validateName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
    }

    private void validateAge(int age) {
        if (age < AGE_LIMIT) {
            throw new IllegalArgumentException("Возраст не может быть меньше 18");
        }
    }

    private void validateJob(String job) {
        if (!isValidValue(job, VALID_JOBS)) {
            throw new IllegalArgumentException("Недопустимое место работы. Допустимые варианты: "
                    + String.join(", ", VALID_JOBS));
        }
    }

    private void validateAddress(String address) {
        if (!isValidValue(address, VALID_ADDRESSES)) {
            throw new IllegalArgumentException("Недопустимый адрес. Допустимые варианты: "
                    + String.join(", ", VALID_ADDRESSES));
        }
    }

    private boolean isValidValue(String value, String[] validValues) {
        for (String validValue : validValues) {
            if (validValue.equals(value)) {
                return true;
            }
        }
        return false;
    }

}
