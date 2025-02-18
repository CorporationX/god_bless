package school.faang.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import school.faang.utils.ValidationUtils;

import java.util.List;

@Getter
@EqualsAndHashCode
@ToString
public class UserProfile {
    private final int userId;
    private final Gender gender;
    private final int age;
    private final String location;
    private final List<String> interests;

    public UserProfile(int userId, Gender gender, int age, String location, List<String> interests) {
        ValidationUtils.isValidString(location, "location");
        ValidationUtils.isValidList(interests, "interest");
        this.userId = userId;
        this.gender = gender;
        this.age = age;
        this.location = location;
        this.interests = interests;
    }
}
