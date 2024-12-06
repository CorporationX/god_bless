package school.faang.bjs243968;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class User {

    private String name;
    private int age;
    private String workPlace;
    private String address;

    public static Map<Integer, List<User>> groupUsers(@NonNull List<User> users) {

        return users.stream()
                .collect(Collectors.groupingBy(User::getAge, Collectors.toList()));

    }

}
