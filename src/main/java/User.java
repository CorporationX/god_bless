import lombok.Getter;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Getter
public class User {
    private String name;
    private int age;
    private String workplace;
    private String address;

    public User(String name, int age, String workplace, String address) {
        if (age <= 0) {
            throw new IllegalArgumentException("Incorrect age");
        }

        this.name = name;
        this.age = age;
        this.workplace = workplace;
        this.address = address;
    }

    public static boolean isValidAge(int age) {
        return age != 0 && age > 0;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> userList) {
        return userList.stream()
                .filter(user -> isValidAge(user.getAge()))
                .collect(Collectors.groupingBy(User::getAge));
    }
}
