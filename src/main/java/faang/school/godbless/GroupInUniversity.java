package faang.school.godbless;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class GroupInUniversity {
    private String faculty;
    private int year;

    public GroupInUniversity(String faculty,int year)
    {
        this.faculty=faculty;
        this.year=year;
    }
}
