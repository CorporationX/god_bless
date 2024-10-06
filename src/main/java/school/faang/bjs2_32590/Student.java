package school.faang.bjs2_32590;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Student {
    private String name;
    private String faculty;
    private int year;

    public FacultyYearPair getFacultyYearPair(){
        return new FacultyYearPair(faculty,year);
    }
}
