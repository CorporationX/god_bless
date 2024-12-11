package school.faang.task_44005;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private String name;
    private Integer age;
    private String workplace;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        if (users == null || users.isEmpty()) {
            throw new IllegalArgumentException("User list cannot be null or empty");
        }
        return users
                .stream()
                .collect(Collectors.groupingBy(User::getAge));
    }

    public static String formatGroupedUsers(Map<Integer, List<User>> groupedUsers) {
        StringBuilder result = new StringBuilder();
        groupedUsers.forEach((age, users) -> {
            result.append("Age: ").append(age).append("\n");
            users.forEach(user -> result.append("  ").append(user).append("\n"));
        });
        return result.toString();
    }

    @Override
    public String toString() {
        return String.format("User{name='%s', age=%d, workplace='%s', address='%s'}",
                name, age, workplace, address);
    }
}
