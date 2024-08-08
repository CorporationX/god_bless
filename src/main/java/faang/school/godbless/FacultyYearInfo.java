package faang.school.godbless;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@AllArgsConstructor
@EqualsAndHashCode
public class FacultyYearInfo {
    private String faculty;
    private int year;

    @Override
    public String toString() {
        return "Faculty: " + faculty + " | Year: " + year;
    }
}