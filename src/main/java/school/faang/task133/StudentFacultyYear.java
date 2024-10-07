package school.faang.task133;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StudentFacultyYear {

    private String faculty;
    private int year;

    public static StudentFacultyYear createNewClassObject(Student student) {
        return new StudentFacultyYear(student.getFaculty(), student.getYear());
    }
}
