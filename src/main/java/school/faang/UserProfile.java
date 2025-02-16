package school.faang;

import java.util.List;

public record UserProfile(int userId, Gender gender, int age, String location, List<String> interests) {
}
