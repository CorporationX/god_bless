package faang.school.godbless;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class FindHobbyLoversTest {

    @Test
    public void testUserFindHobbyLovers() {

        User vlad = User.builder()
                .id(1L)
                .name("Vlad")
                .age(26)
                .activities(Set.of("coding", "obs_setting", "mentoring"))
                .build();

        User vitalii = User.builder()
                .id(2L)
                .name("Vitalii")
                .age(26)
                .activities(Set.of("start-upping", "sessions_recording", "project_management"))
                .build();

        User student = User.builder()
                .id(3L)
                .name("Junior")
                .age(26)
                .activities(Set.of("studying", "knocking_on_faang_doors", "developing"))
                .build();

        User hater = User.builder()
                .id(4L)
                .name("Hater")
                .age(100)
                .activities(Set.of("hate_comment_writing", "crying", "beer_drinking"))
                .build();

        Set<String> activities = Set.of("coding", "start-upping", "developing");
        List<User> users = List.of(vlad, vitalii, student, hater);

        Map<User, String> resultMap = User.findHobbyLovers(users, activities);

        Assertions.assertEquals(3, resultMap.size());

        Assertions.assertEquals("coding", resultMap.get(vlad));
        Assertions.assertEquals("start-upping", resultMap.get(vitalii));
        Assertions.assertEquals("developing", resultMap.get(student));
    }
}
