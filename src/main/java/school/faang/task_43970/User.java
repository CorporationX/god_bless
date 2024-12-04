package school.faang.task_43970;

import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Getter
public class User {

    private int id;
    private String name;
    private int age;
    private List<String> hobby;

    public User(int id, String name, int age, List<String> hobby) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.hobby = hobby;
    }

    public static Map<User, String> findHobbyLovers(List<User> userList, List<String> hobbyList) {
        Map<User, String> userStringMap = new HashMap<>();
        for (User user : userList) {
            for (String hobbyUser : user.getHobby()) {
                if (!userStringMap.containsKey(user)) {
                    hobbyList.stream()
                            .filter(hobbyUser::equals)
                            .findFirst()
                            .map(hobby -> userStringMap.put(user, hobby));
                }
            }
        }
        return userStringMap;
    }
}
