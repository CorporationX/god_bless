package faang.school.godbless.BJS2_19305;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@AllArgsConstructor
@EqualsAndHashCode
@Data
public class Student {
    private String name;
    private String faculty;
    private int yearOfStudy;

    @Override
    public String toString() {
        return "Student " +
                "name: " + name +
                ", faculty: " + faculty +
                ", yearOfStudy: " + yearOfStudy;
    }
}
