package school.faang.bjs231347.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@AllArgsConstructor
@Getter
@NonNull
public class User {
    @NonNull
    private String name;
    @NonNull
    private Integer age;
    @NonNull
    private String workPlace;
    @NonNull
    private String address;

    public static Map<Integer, List<User>> groupUsers (List<User> userList) {
        Map<Integer, List<User>> groupResult = new HashMap<>();
        for (User user : userList) {
            if (Objects.nonNull(user)) {
                groupResult.merge(user.getAge(), new LinkedList<>(List.of(user)), (k, v) -> {
                    v.add(user);
                    return v;
                });
            }
        }
        return groupResult;
    }
}
