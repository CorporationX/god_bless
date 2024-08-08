package faang.school.godbless;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@AllArgsConstructor
@EqualsAndHashCode
public class Student {
    private String name;
    private String faculty;
    private int year;

    @Override
    public String toString() {
        return "Name: " + name + ", Faculty: " + faculty + ", Year: " + year;
    }
}