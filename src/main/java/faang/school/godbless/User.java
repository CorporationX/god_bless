package faang.school.godbless;

import lombok.Data;

import java.util.*;
import java.util.stream.Collectors;

@Data
public class User {
    public static final Set<String> VALID_JOBS = new HashSet<>(Arrays.asList("Google", "Uber", "Amazon"));
    public static final Set<String> VALID_ADDRESSES = new HashSet<>(Arrays.asList("London", "New York", "Amsterdam"));
    public static final int ADULT_AGE = 18;
    private String name;
    private int age;
    private String workAddress;
    private String address;

    public User(String name, int age, String workAddress, String address) {
        StringBuilder errorMessage = new StringBuilder();

        if (name == null || name.isBlank()) {
            errorMessage.append("Имя не может быть пустым или null. ");
        }

        if (age < ADULT_AGE) {
            errorMessage.append("Возраст должен быть не менее 18. ");
        }

        if (!VALID_JOBS.contains(workAddress)) {
            errorMessage.append("Рабочее место должно быть валидным. ");
        }

        if (!VALID_ADDRESSES.contains(address)) {
            errorMessage.append("Адрес должен быть валидным. ");
        }

        if (!errorMessage.isEmpty()) {
            throw new IllegalArgumentException("Ошибка заполнения полей: " + errorMessage);
        }

        this.name = name;
        this.age = age;
        this.workAddress = workAddress;
        this.address = address;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        return users.stream().collect(Collectors.groupingBy(User::getAge));
    }
}

