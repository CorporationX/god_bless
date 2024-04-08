package faang.school.godbless.university;

import lombok.ToString;
import java.util.Objects;

@ToString
public class Pair {
    private String faculty;
    private int year;

    public Pair(String faculty, int year) {
        this.faculty = faculty;
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        return year == pair.year && Objects.equals(faculty, pair.faculty);
    }

    @Override
    public int hashCode() {
        return Objects.hash(faculty, year);
    }
}
