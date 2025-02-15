package school.faang.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@EqualsAndHashCode
@ToString
public class UserProfile {
    private final int userId;
    private final String gender;
    private final int age;
    private final String location;
    private final List<String> interests;

    public UserProfile(int userId, String gender, int age, String location, List<String> interests) {
        validateString(gender, "gender");
        validateString(location, "location");
        validateInterests(interests);
        this.userId = userId;
        this.gender = gender;
        this.age = age;
        this.location = location;
        this.interests = interests;
    }

    private void validateString(String argument, String message) {
        if (argument == null || argument.isBlank()) {
            throw new IllegalArgumentException("The " + message + " can't be null or blank.");
        }
    }

    private void validateInterests(List<String> interests) {
        if (interests == null) {
            throw new IllegalArgumentException("List of interests can't be null.");
        }
        for (String interest : interests) {
            validateString(interest, "interest in list");
        }
    }
}
