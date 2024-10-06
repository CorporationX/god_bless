package school.faang.countingabsenteeism_main;

import school.faang.countingabsenteeism_maincode.Student;
import school.faang.countingabsenteeism_maincode.StudentService;
import school.faang.countingabsenteeism_maincode.UniversityFlow;
import java.util.List;
import java.util.Map;

import static school.faang.countingabsenteeism_maincode.StudentService.students;

public class Main {
    public static void main(String[] args) {
        Student firstStudent = new Student("Gadzhi", "informatic", 2);
        Student secondStudent = new Student("Matvey", "informatic", 2);
        Student thirdStudent = new Student("Andrey", "ecolog", 3);


        StudentService.addStudent(firstStudent);
        StudentService.addStudent(secondStudent);
        StudentService.addStudent(thirdStudent);

        System.out.println(StudentService.groupedStudent(students));

        Map<UniversityFlow, List<Student>> studentGroup = StudentService.groupedStudent(students);

        StudentService.findStudent("ecolog", 3, studentGroup);

        StudentService.removeStudent("Gadzhi", "informatic", 2);

        StudentService.printAll();
    }
}
