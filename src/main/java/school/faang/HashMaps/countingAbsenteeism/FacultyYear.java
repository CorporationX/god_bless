package school.faang.HashMaps.countingAbsenteeism;

import lombok.Builder;
import lombok.Data;

import java.util.Objects;

@Data
@Builder
public class FacultyYear {
    private String faculty;
    private int year;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FacultyYear that = (FacultyYear) o;
        return year == that.year && Objects.equals(faculty, that.faculty);
    }

    @Override
    public int hashCode() {
        return Objects.hash(faculty, year);
    }
}
