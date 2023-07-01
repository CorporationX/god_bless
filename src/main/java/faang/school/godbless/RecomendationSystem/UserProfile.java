package faang.school.godbless.RecomendationSystem;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class UserProfile {
    private int userId;

    private Gender gender;

    private int age;

    private String location;

    private List<String> interests;
}
