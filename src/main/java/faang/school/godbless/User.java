package faang.school.godbless;

import java.util.Collection;
import java.util.HashMap;
import java.util.stream.Collectors;

public class User {

    private String name;
    private Integer age;
    private String WorkPlace;
    private String address;

    public User(String userName, Integer userAge, String userWorkPlace, String userAddress) {

    }

    public static Map<Integer, List<User>> convertListUserToMap(List<User> listUsers) {
        return listUsers.stream().collect(Collectors.groupingBy(User::getUserAge, Collectors.toList()));

    }
}
