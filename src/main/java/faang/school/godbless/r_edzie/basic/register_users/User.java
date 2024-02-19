package faang.school.godbless.r_edzie.basic.register_users;

import java.util.Set;

public class User {
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private String name;
    private int age;
    private String job;
    private String address;

    User(String name, int age, String job, String address) {
        validate(name, age, job, address);

        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }

    private void validate(String name, int age, String job, String address) {
        if (age < 18) {
            throw new IllegalArgumentException("Вам должно быть больше 18-ти лет");
        }

        if (name.isBlank()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }

        if (!(VALID_JOBS.contains(job))) {
            throw new IllegalArgumentException("Такой работы нет в нашей базе");
        }

        if (!(VALID_ADDRESSES.contains(address))) {
            throw new IllegalArgumentException("Такого адресса нет в нашей базе");
        }
    }
}
