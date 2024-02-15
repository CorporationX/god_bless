package faang.school.godbless;

import lombok.Getter;

@Getter
public class GroupInUniversity {
    private String faculty;
    private int year;

    public GroupInUniversity(String faculty,int year)
    {
        this.faculty=faculty;
        this.year=year;
    }
}
