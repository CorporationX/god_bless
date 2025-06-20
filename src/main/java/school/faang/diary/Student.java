package school.faang.diary;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;
import java.util.Map;

/**
 * @author Danil Pudovkin
 * @since 20.06.2025
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString(of = {"firstName", "lastName"})
@EqualsAndHashCode(of = {"firstName", "lastName"})
public class Student {

    private String firstName;
    private String lastName;
    private Map<String, List<Integer>> subjects;
}
