package faang.school.godbless.secondSprint.RecommenderSystem;

import java.util.List;

public record UserProfile(int userId, String gender, int age, String location, List<String> interest) {
}
