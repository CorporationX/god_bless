package faang.school.godbless;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class FacultyYearInfo {
    private String faculty;
    private int year;

    FacultyYearInfo(String faculty, int year) {
        if (faculty == null || faculty.isEmpty()) {
            throw new IllegalArgumentException("faculty cannot be null or empty");
        }
        this.faculty = faculty;
        this.year = year;
    }
    @Override
    public String toString() {
        return "Faculty: " + faculty + " | Year: " + year;
    }
}