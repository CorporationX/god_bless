package school.faang.sprint2.task_47283;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class UserProfile {
    private final int userId;
    private final String gender;
    private final int age;
    private final String location;
    private final List<String> interests;

    @JsonCreator
    public UserProfile(
            @JsonProperty("userId") int userId,
            @JsonProperty("gender") String gender,
            @JsonProperty("age") int age,
            @JsonProperty("location") String location,
            @JsonProperty("interests") List<String> interests) {
        this.userId = userId;
        this.gender = gender;
        this.age = age;
        this.location = location;
        this.interests = interests;
    }
}
