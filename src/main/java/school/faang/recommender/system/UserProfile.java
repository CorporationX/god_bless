package school.faang.recommender.system;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserProfile {
    private int userId;
    private String gender;
    private int age;
    private String location;
    private List<String> interests;

    public boolean similar(UserProfile other) {
        if (other == null) {
            return false;
        }
        return this.getAge() == other.getAge() &&
                this.getGender().equals(other.getGender()) &&
                this.getLocation().equals(other.getLocation());
    }
}
