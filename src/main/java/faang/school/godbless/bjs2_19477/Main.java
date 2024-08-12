package faang.school.godbless.bjs2_19477;

import com.google.common.collect.Lists;

import static faang.school.godbless.bjs2_19477.Faculty.GO;
import static faang.school.godbless.bjs2_19477.Faculty.JAVA;
import static faang.school.godbless.bjs2_19477.Faculty.PYTHON;

public class Main {
    public static void main(String[] args) {
        var student1 = Student.builder().name("1").faculty(JAVA).year(1).build();
        var student2 = Student.builder().name("2").faculty(JAVA).year(2).build();
        var student3 = Student.builder().name("3").faculty(PYTHON).year(1).build();
        var student4 = Student.builder().name("4").faculty(PYTHON).year(1).build();
        var student5 = Student.builder().name("5").faculty(GO).year(2).build();
        var student6 = Student.builder().name("6").faculty(JAVA).year(2).build();

        var students = Lists.newArrayList(student1, student2, student3, student4, student5, student6);

        var studentService = new StudentService();

        var groupedStudents = studentService.groupStudentsByFacultyAndYear(students);
        var groupedStudentsJava8 = studentService.groupStudentsByFacultyAndYearJava8(students);

        var student7 = Student.builder().name("7").faculty(JAVA).year(2).build();
        studentService.addStudentToGroupedStudents(student7, groupedStudents);

        studentService.removeStudentFromGroupedStudents(student2, groupedStudents);

        var foundStudents = studentService.findStudentsByFacultyYear(new StudentsFinderByFacultyYear(JAVA, 2), groupedStudents);
        studentService.printUsersList(foundStudents);
        System.out.println("----------------");

        studentService.printStudents(groupedStudents);
        System.out.println("----------------");

        studentService.printStudentsWithSorting(groupedStudents);
    }
}
