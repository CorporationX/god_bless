package faang.school.godbless.BJS2_19700;

import lombok.Data;

import java.util.Objects;

@Data
public class CompositeKeyFacultyYear {
    private String faculty;
    private int year;

    public CompositeKeyFacultyYear(String faculty, int year) {
        this.faculty = faculty;
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CompositeKeyFacultyYear that)) return false;
        return getYear() == that.getYear() && Objects.equals(getFaculty(), that.getFaculty());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFaculty(), getYear());
    }
}
