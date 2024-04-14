package faang.school.godbless.recommendation_system.model;

import lombok.Data;

import java.util.List;

@Data
public class UserProfile {
    private static int startId = 0;
    private int id;
    private Gender gender;
    private int age;
    private String location;
    private List<String> interests;

    public UserProfile(Gender gender, int age, String location, List<String> interests) {
        this.id = startId++;
        this.gender = gender;
        this.age = age;
        this.location = location;
        this.interests = interests;
    }
}