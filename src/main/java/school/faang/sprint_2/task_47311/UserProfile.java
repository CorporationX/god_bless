package school.faang.sprint_2.task_47311;

import java.util.List;

public record UserProfile(int userId, Gender gender, int age, String location, List<String> interests) {
}
