package school.faang.BJS2_68100;

import lombok.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@ToString
public class User {

    private String name;

    private int age;

    private String workplace;

    private String address;


    public User(String name, int age, String workplace, String address) {
        this.name = name;
        this.age = age;
        this.workplace = workplace;
        this.address = address;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {

        return users.stream().collect(Collectors.groupingBy(User::getAge));

    }

}
