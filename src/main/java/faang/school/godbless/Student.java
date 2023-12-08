package faang.school.godbless;

import lombok.Getter;

@Getter
public class Student {
    private String name;
    private String faculty;
    private int course;
    public Student(String name, String faculty, int course){
        this.name=name;
        this.faculty=faculty;
        this.course=course;
    }
    public String toString(){
        return getName()+", "+getFaculty()+", "+getCourse();
    }
}
