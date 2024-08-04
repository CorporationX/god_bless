package faang.school.godbless.task;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Objects;

@AllArgsConstructor
@ToString
@Getter
public class DataFilter {
    private String faculty;
    private int year;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DataFilter dataFilter = (DataFilter) o;
        return year == dataFilter.year && Objects.equals(faculty, dataFilter.faculty);
    }

    @Override
    public int hashCode() {
        return Objects.hash(faculty, year);
    }
}
