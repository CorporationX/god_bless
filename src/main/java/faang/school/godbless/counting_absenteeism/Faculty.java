package faang.school.godbless.counting_absenteeism;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Faculty {
    private String title;
    private int year;

    public Faculty(String title, int year) {
        if (title == null) {
            throw new IllegalArgumentException("Title cannot be null");
        }
        if (title.isEmpty()) {
            throw new IllegalArgumentException("Title cannot be empty");

        }
        if (year < 0) {
            throw new IllegalArgumentException("Year cannot be negative");
        }
        this.title = title;
        this.year = year;
    }
}
