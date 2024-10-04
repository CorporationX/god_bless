package school.faang.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@AllArgsConstructor
@Getter
@Builder
@NonNull
@EqualsAndHashCode
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
                if (groupResult.containsKey(user.getAge())) {
                    groupResult.get(user.getAge()).add(user);
                } else {
                    groupResult.put(user.getAge(), new LinkedList<>(List.of(user)));
                }
            }
        }
        return groupResult;
    }
}
