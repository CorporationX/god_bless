package school.faangSprint2.t21;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class UserProfile {
    private String userId;
    private String gender;
    private int age;
    private String location;
    private List<String> interests;
}