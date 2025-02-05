package school.faang.grouping_users_by_age.BJS2_56339.BJS2_56339;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@AllArgsConstructor
@Getter
public class User {

    private final String name;
    private final int age;
    private final String workplace;
    private final String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> userGroups = new HashMap<>();

        for (User user : users) {
            userGroups.computeIfAbsent(user.getAge(), k -> new ArrayList<>()).add(user);
        }
        return userGroups;
    }

    @Override
    public boolean equals(Object o) {
        return this == o || (o instanceof User user
                && Objects.equals(age, user.age)
                && Objects.equals(name, user.name)
                && Objects.equals(workplace, user.workplace)
                && Objects.equals(address, user.address));
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, workplace, address);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append("User{")
                .append("name=").append(name)
                .append(", age=").append(age)
                .append(", workplace=").append(workplace)
                .append(", address=").append(address)
                .append("}");
        return stringBuilder.toString();
    }
}
