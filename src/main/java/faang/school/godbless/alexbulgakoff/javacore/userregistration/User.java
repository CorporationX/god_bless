package faang.school.godbless.alexbulgakoff.javacore.userregistration;

import lombok.ToString;

import java.util.Set;

/**
 * @author Alexander Bulgakov
 */

@ToString
public class User {

    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");

    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    private static final int VALID_AGE = 18;

    private String name;

    private int age;

    private String jobName;

    private String address;

    public User(String name, Integer age, String jobName, String address) {
        if (checkParameters(name, age, jobName, address)) {
            this.name = name;
            this.age = age;
            this.jobName = jobName;
            this.address = address;
        }
    }

    private String removeSpaces(String input) {
        return input.replaceAll("\\s","");
    }

    private boolean checkParameters(String name, Integer age, String jobName, String address) {
        if (removeSpaces(name).isEmpty()) {
            throw new IllegalArgumentException("Не введено имя пользователя");
        } else if (removeSpaces(jobName).isEmpty()) {
            throw new IllegalArgumentException("Не введено место работы");
        } else if (removeSpaces(address).isEmpty()) {
            throw new IllegalArgumentException("Не введен адрес работы");
        } else if (age < VALID_AGE) {
            throw new IllegalArgumentException("Возраст пользователя не достиг 18ти лет");
        } else if (!VALID_JOBS.contains(jobName)) {
            throw new IllegalArgumentException("Место работы не входит в список компаний");
        } else if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Адрес работы не входит в список доступных адресов");
        } else {
            return true;
        }
    }

}
