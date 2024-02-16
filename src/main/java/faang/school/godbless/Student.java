package faang.school.godbless;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class Student {
    private String name,faculty;
    private int year;

    public Student(String name,String faculty,int year){
    this.year=year;
    this.name=name;
    this.faculty=faculty;
    }
}
