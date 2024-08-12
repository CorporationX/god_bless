package progul;

import java.util.List;
import java.util.Map;


public class Main {
    public static void main(String[] args) {
        List<Student> studentList = List.of(new Student("Max", "Gryffindor", 1990),
                new Student("Kirill", "Gryffindor", 1990),
                new Student("Gosha", "Slytherin", 1991),
                new Student("Max", "Slytherin", 1991));

        Map<String,List<Student>> nameByStudent = Student.mapStudent(studentList);

        Student.outputMap(nameByStudent);
        Student.addStudent(nameByStudent, new Student("Katya", "Slytherin", 2000));
        Student.removeStudent(nameByStudent,"Max", "Gryffindor", 1990 );
        Student.searchStudent(nameByStudent,"Slytherin", 1991);
        Student.outputMap(nameByStudent);
    }
}
