package faang.school.godbless;

import lombok.Getter;

import java.util.List;

@Getter
public class UserProfile {
    private int userId;
    private String gender;
    private int age;
    private String location;
    private List<String> interests;

    public UserProfile(int userId, String gender, int age, String location, List<String> interests) {
        this.userId = userId;
        this.gender = gender;
        this.age = age;
        this.location = location;
        this.interests = interests;
    }
}
