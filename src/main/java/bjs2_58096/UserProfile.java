package bjs2_58096;

import java.util.List;

public record UserProfile(int userId, Gender gender, int age, String location, List<String> interests) {
}
