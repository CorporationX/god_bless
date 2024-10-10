package countingabsences;

import static countingabsences.StudentsService.addNewStudent;
import static countingabsences.StudentsService.getStudentsByFacultyAndYear;
import static countingabsences.StudentsService.printAllStudentsByFacultyAndYear;
import static countingabsences.StudentsService.removeStudent;

public class Main {
    public static void main(String[] args) {
        addNewStudent(new Student("student1", "faculty1", 1));
        addNewStudent(new Student("student2", "faculty1", 1));
        addNewStudent(new Student("student3", "faculty2", 2));
        addNewStudent(new Student("student4", "faculty3", 3));
        addNewStudent(new Student("student5", "faculty3", 3));

        printAllStudentsByFacultyAndYear();
        removeStudent("student4", "faculty3", 3);
        System.out.println(getStudentsByFacultyAndYear("faculty3", 3));
        printAllStudentsByFacultyAndYear();
    }
}
