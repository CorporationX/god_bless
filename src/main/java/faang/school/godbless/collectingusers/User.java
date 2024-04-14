package faang.school.godbless.collectingusers;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.List;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;

@Data
@Builder
@AllArgsConstructor
public class User {
    private final int id;
    private final String name;
    private final Set<String> hobbies;
    private int age;

    public static Map<User, String> findHobbyLovers(List<User> usersList, Set<String> hobbiesSet) {
        return usersList.stream()
                .collect(Collectors.toMap(Function.identity(), u -> getMatch(hobbiesSet, u.getHobbies())));
    }

    private static String getMatch(Set<String> hobbiesSetFromRequest, Set<String> hobbiesSetFromUser) {
        for (String userHobby : hobbiesSetFromUser) {
            if (hobbiesSetFromRequest.contains(userHobby)) {
                return userHobby;
            }
        }
        return "";
    }

    public static void main(String[] args) {
        Set<String> hobbies1 = new TreeSet<>(String::compareTo);
        hobbies1.addAll(Set.of("hobby1", "hobby2", "hobby3"));
        Set<String> hobbies2 = new TreeSet<>(String::compareTo);
        hobbies2.addAll(Set.of("hobby4", "hobby5", "hobby6"));
        Set<String> hobbies3 = new TreeSet<>(String::compareTo);
        hobbies3.addAll(Set.of("hobby7", "hobby8", "hobby9"));

        User user1 = User.builder()
                .id(1)
                .name("user1")
                .age(20)
                .hobbies(new TreeSet<>(hobbies1))
                .build();
        User user2 = User.builder()
                .id(2)
                .name("user2")
                .age(20)
                .hobbies(new HashSet<>(hobbies2))
                .build();
        User user3 = User.builder()
                .id(3)
                .name("user3")
                .age(20)
                .hobbies(new HashSet<>(hobbies3))
                .build();

        List<User> usersList = new ArrayList<>(List.of(user1, user2, user3));
        Set<String> hobbiesSet = new TreeSet<>(String::compareTo);
        hobbiesSet.addAll(Set.of("hobby1", "hobby2", "hobby3", "hobby4", "hobby5", "hobby6", "hobby7", "hobby8", "hobby9"));

        Map<User, String> result = User.findHobbyLovers(usersList, hobbiesSet);
        System.out.println(result);
    }
}

