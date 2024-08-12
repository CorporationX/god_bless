package user.absenteeism;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Faculty {
    private final String faculty;
    private final int years;

    public Faculty(String faculty, int years) {
        this.faculty = faculty;
        this.years = years;
    }

}
