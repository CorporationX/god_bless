package faang.school.godbless.task_4;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;
import java.util.Map;

@EqualsAndHashCode
@ToString
@AllArgsConstructor
public class University {
    private String faculty;
    private String course;


    List<Student> studentList;
    Map<University, List<Student>> universityMap;

    public void addStudent(Student student){
        if (studentList.contains(student)){
            System.out.println("There is already such a student at the University!");
        } else {

        }
    }
    public void removeStudent(){

    }
    public void searchStudent(){

    }
    public void getAllStudentS(){

    }
}
