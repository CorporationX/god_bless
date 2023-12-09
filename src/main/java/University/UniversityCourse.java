package University;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class UniversityCourse {
    private String faculty;
    private int year;

    public UniversityCourse() {
    }

    public UniversityCourse(String faculty, int year) {
        this.faculty = faculty;
        this.year = year;
    }

    @Override
    public String toString() {
        return "UniversityCourse{" +
                "faculty='" + faculty + '\'' +
                ", year=" + year +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UniversityCourse that = (UniversityCourse) o;
        return year == that.year && Objects.equals(faculty, that.faculty);
    }

    @Override
    public int hashCode() {
        return Objects.hash(faculty, year);
    }
}
