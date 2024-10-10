package electronic_diary;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private String firstName;
    private String lastName;
    private Map<String, List<Integer>> subjects;

    /**
     * Returns the full name of the student in the format "firstName lastName".
     *
     * @return The full name of the student.
     */
    public String getFullName() {
        return firstName + " " + lastName;
    }
}
