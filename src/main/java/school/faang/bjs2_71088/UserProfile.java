package school.faang.bjs2_71088;

import java.util.List;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode()
@ToString
public class UserProfile {
    private static int counter = 0;
    @EqualsAndHashCode.Include
    private final int userId;
    private String gender;
    private int age;
    private String location;
    private List<String> interests;

    public UserProfile(String gender, int age, String location, List<String> interests) {
        this.userId = counter++;
        this.gender = gender;
        this.age = age;
        this.location = location;
        this.interests = interests;
    }

    public UserProfile(int userId, String gender, int age, String location, List<String> interests) {
        this.userId = userId;
        this.gender = gender;
        this.age = age;
        this.location = location;
        this.interests = interests;
    }
    
}
