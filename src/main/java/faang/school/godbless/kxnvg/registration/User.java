package faang.school.godbless.kxnvg.registration;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@EqualsAndHashCode
@ToString
public class User {

    private String userName;
    private int userAge;
    private String userJob;
    private String userAddress;

    private static final Set<String> VALID_JOBS = new HashSet<>(Arrays.asList("Google", "Uber", "Amazon"));
    private static final Set<String> VALID_ADDRESSES = new HashSet<>(Arrays.asList("London", "New York", "Amsterdam"));

    public User(String userName, int userAge, String userJob, String userAddress) {
        constructorValidation(userName, userAge, userJob, userAddress);

        this.userName = userName;
        this.userAge = userAge;
        this.userJob = userJob;
        this.userAddress = userAddress;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        return users.stream()
                .collect(Collectors.groupingBy(User::getUserAge));
    }

    private void constructorValidation(String userName, int userAge, String userJob, String userAddress) throws IllegalArgumentException {
        if (userName == null || userName == "") {
            throw new IllegalArgumentException("Имя не может быть пустым");
        } else if (userAge < 18) {
            throw  new IllegalArgumentException("Возраст не может быть меньше 18");
        } else if (!VALID_JOBS.contains(userJob)) {
            throw new IllegalArgumentException("Такое место работы не зарегестрировано");
        } else if (!VALID_ADDRESSES.contains(userAddress)) {
            throw new IllegalArgumentException("Такой адрес не разрегестрирован");
        }
    }


}
