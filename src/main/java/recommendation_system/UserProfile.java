package recommendation_system;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserProfile {
    private int userId;
    private String gender;
    private int age;
    private String location;
    private List<String> interests;
}
