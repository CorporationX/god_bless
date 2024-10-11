package school.faang.countingabsenteeism;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pair {
    private String faculty;
    private int year;

    public Pair(String faculty) {
        this.faculty = faculty;
        this.year = year;
    }
}
