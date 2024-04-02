package colletcionOfUsers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
    private long id;
    private String name;
    private int age;
    private List<String> hobbies = new ArrayList<>();

    public static Map<User, String> findHobbyLovers(List<User> users, List<String> hobbies){
        Map<User, String> userHobbyLover = new HashMap<>();
        for (User user : users) {
            for (String hobby : user.getHobbies()) {
                if (hobbies.contains(hobby)) {
                    userHobbyLover.put(user, hobby);
                }
            }
        }
        return userHobbyLover;
    }
}


