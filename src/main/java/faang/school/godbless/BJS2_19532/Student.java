package faang.school.godbless.BJS2_19532;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

@Getter
@AllArgsConstructor
public class Student {

    private String name;
    private String faculty;
    private int year;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student student)) return false;
        return getYear() == student.getYear() && Objects.equals(getName(), student.getName()) && Objects.equals(getFaculty(), student.getFaculty());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getFaculty(), getYear());
    }
}
