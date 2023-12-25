package faang.school.godbless.alexbulgakoff.collectionstreamapioptional.recomendationsystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Alexander Bulgakov
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserProfile {
    private int userId;
    private String gender;
    private int age;
    private String location;
    private List<String> interests;
}
