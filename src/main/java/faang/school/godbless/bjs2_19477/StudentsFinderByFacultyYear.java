package faang.school.godbless.bjs2_19477;

import java.util.Comparator;
import java.util.Objects;

public class StudentsFinderByFacultyYear extends StudentsFinder implements Comparable {

    public StudentsFinderByFacultyYear(Faculty faculty, int year) {
        super(faculty, year);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }

        StudentsFinderByFacultyYear that = (StudentsFinderByFacultyYear) o;
        return this.faculty == that.faculty
                && this.year == that.year;
    }

    @Override
    public int hashCode() {
        return Objects.hash(faculty, year);
    }

    @Override
    public int compareTo(Object o) {
        StudentsFinderByFacultyYear other = (StudentsFinderByFacultyYear) o;
        return Comparator
                .comparing((StudentsFinderByFacultyYear f) -> f.faculty.name())
                .thenComparingInt(f -> f.year)
                .compare(this, other);
    }
}
