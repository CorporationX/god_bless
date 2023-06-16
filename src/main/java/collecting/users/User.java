package collecting.users;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
public class User {
    private int id;
    private String name;
    private int age;
    private List<String> activities;


    public Map<User, String> findHobbyLovers(List<User> users, List<String> activities) {
        return null;
    }
}
