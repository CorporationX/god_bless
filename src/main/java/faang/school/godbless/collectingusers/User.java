package faang.school.godbless.collectingusers;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;
import java.util.Set;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class User {
    private final int id;
    private final String name;
    private final Set<String> hobbies;
    private int age;

    public Map<User, String> findHobbyLovers(List<User> usersList, Set<String> hobbiesSet) {
        return usersList.stream()
                .collect(Collectors.toMap(Function.identity(), u -> getMatch(hobbiesSet, u.getHobbies())));
    }

    private String getMatch(Set<String> hobbiesSetFromRequest, Set<String> hobbiesSetFromUser) {
        for (String userHobby : hobbiesSetFromRequest) {
            if (hobbiesSetFromUser.contains(userHobby)) {
                return userHobby;
            }
        }
        return "";
    }

    public static void main(String[] args) {

    }
}