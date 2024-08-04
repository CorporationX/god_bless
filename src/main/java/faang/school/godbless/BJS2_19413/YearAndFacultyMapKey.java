package faang.school.godbless.BJS2_19413;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Objects;

@AllArgsConstructor @Getter @ToString
public class YearAndFacultyMapKey {

    private String faculty;
    private int year;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        YearAndFacultyMapKey that = (YearAndFacultyMapKey) o;
        return year == that.year && faculty.equals(that.faculty);
    }

    @Override
    public int hashCode() {
        return Objects.hash(faculty, year);
    }



}