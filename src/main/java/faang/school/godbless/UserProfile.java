package faang.school.godbless;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class UserProfile {
    private int userId;
    private String gender;
    private int age;
    private String location;
    private List<String> interests;
}
