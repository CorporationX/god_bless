package faang.school.godbless.registerusers;

import faang.school.godbless.registerusers.validation.UserValidator;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

@Data
@Builder
public class User {
    private final String name;
    private int age;
    private String company;
    private String address;

    public User(final String name, final int age, final String company, final String address) {
        UserValidator.validateParametersOfUser(name, age, company, address);
        this.name = name;
        this.age = age;
        this.company = company;
        this.address = address;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> list) {
        return list.stream()
                .collect(groupingBy(User::getAge));
    }
}
