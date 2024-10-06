package school.faang.task133;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
public class Cohort {

    private String faculty;
    private int year;

    public static Cohort createNewCohort(Student student) {
        return new Cohort(student.getFaculty(), student.getYear());
    }
}
