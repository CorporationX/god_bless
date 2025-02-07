package school.faang.naughtwoBJS256448;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Getter
@EqualsAndHashCode
public class User {
    private final String name;
    private final int age;
    private final String workplace;
    private final String address;

    public User(String name, int age, String workplace, String address) {
        this.name = name;
        this.age = age;
        this.workplace = workplace;
        this.address = address;
    }

    @Override
    public String toString() {
        return String.format("User: name- %s, age- %d, workplace- %s, address- %s",
                this.getName(), this.getAge(), this.getWorkplace(), this.getAddress());
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> usersMap = users.stream()
                .collect(Collectors.groupingBy(User::getAge));
        return usersMap;
    }
}
