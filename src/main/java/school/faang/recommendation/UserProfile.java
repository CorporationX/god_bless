package school.faang.recommendation;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
public class UserProfile {
    private final int userId;
    private final Gender gender;
    private final int age;
    private final String location;
    private final List<String> interests;
}
