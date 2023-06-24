package faang.school.godbless.sprint3.streamAPI.task7.model;

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
