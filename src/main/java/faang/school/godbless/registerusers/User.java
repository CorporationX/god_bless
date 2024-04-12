package faang.school.godbless.registerusers;

import faang.school.godbless.registerusers.validation.UserValidator;
import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Data
public class User {

    private final String name;
    private Integer age;
    private String company;
    private String address;

    public User(final String name, final Integer age, final String company, final String address) {
        UserValidator.validateParametersOfUser(name, age, company, address);
        this.name = name;
        this.age = age;
        this.company = company;
        this.address = address;
    }

    private static List<User> getListOfUsersByAge(final Integer age, final List<User> list) {
        return list.stream()
                .filter(u -> u.getAge().equals(age))
                .collect(Collectors.toList());
    }

    public static Map<Integer, List<User>> groupUsers(final List<User> list) {
        return list.stream()
                .collect(Collectors.toMap(User::getAge, u -> getListOfUsersByAge(u.getAge(), list)));
    }
}
