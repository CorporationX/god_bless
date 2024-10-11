package school.faang.countingabsenteeism;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Objects;

@Data
@AllArgsConstructor
public class Pair {
    private String faculty;
    private int year;

    public Pair(String faculty) {

    }

    @Override
    public String toString() {
        return "Pair{" +
                "faculty='" + faculty + '\'' +
                ", year=" + year +
                '}';
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
