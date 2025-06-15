package school.faang.bjs2_80767_recom_system;

import java.util.Set;

public record UserProfile(int userId, Gender gender, int age, String location, Set<String> interests) {
}
