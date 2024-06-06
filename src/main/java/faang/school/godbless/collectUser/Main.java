package faang.school.godbless.collectUser;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        User firstUser = User.builder()
                .id("aa4c-bb4c-cc4c-dd4c")
                .name("first user")
                .age(20)
                .activities(Set.of("activity 1", "activity 2", "activity 3"))
                .build();

        User secondUser = User.builder()
                .id("aa4d-bb4d-cc4d-dd4d")
                .name("second user")
                .age(20)
                .activities(Set.of("activity 1", "activity 3"))
                .build();

        Map<User, String> hobbyLovers = firstUser.findHobbyLovers(List.of(firstUser, secondUser), Set.of("activity 1", "activity 3"));

        System.out.println(hobbyLovers);
    }
}
