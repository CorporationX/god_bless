package faang.school.godbless.kxnvg.grouping;

import lombok.Getter;
import lombok.NonNull;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Getter
public class User {

    @NonNull
    private String userName;
    private int userAge;
    private String userJob;
    private String userAddress;

    public User(String userName, int userAge, String userJob, String userAddress) {
        if (userAge < 0) {
            throw new IllegalArgumentException("Возраст должен быть не меньше 0...");
        }
        this.userName = userName;
        this.userAge = userAge;
        this.userJob = userJob;
        this.userAddress = userAddress;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        return users.stream()
                .collect(Collectors.groupingBy(User::getUserAge));
    }

}
