package RecommendSystem;

import java.util.List;

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

    public int getUserId() {
        return userId;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public String getLocation() {
        return location;
    }

    public List<String> getInterests() {
        return interests;
    }
}

