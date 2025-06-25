package school.faang.recomendation.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author Danil Pudovkin
 * @since 21.06.2025
 */
@Data
@EqualsAndHashCode(of = "userId")
public class UserProfile {

    private int userId;
    private Gender gender;
    private int age;
    private String location;
    private List<String> interests;
}
