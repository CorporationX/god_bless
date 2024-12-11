package school.faang.sprint_1.BJS2_44021;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
public class User {
    private String name;
    private int age;
    private String workplace;
    private String address;

    @Override
    public String toString() {
        return name + ", работает в '" + workplace + "', живет в городе " + address + '.';
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        return users.stream().collect(Collectors.groupingBy(User::getAge));
    }
}
