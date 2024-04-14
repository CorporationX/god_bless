package faang.school.godbless.bjs2_5319;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class UserProfile {

    private int userId;
    private Gender gender;
    private int age;
    private String location;
    private List<String> interests;
}
