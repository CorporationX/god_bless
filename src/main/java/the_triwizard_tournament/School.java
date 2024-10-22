package the_triwizard_tournament;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;


@Data
@AllArgsConstructor
public class School {
    private String name;
    private List<Student> students;

    /**
     * Calculates the total points earned by all students of this school.
     *
     * @return total points
     */
    public int getTotalPoints() {
        return students.stream().mapToInt(Student::getPoints).sum();
    }
}
