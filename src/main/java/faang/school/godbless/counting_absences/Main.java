package faang.school.godbless.counting_absences;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Student student1 = new Student("A", "Engineering", 1);
        Student student2 = new Student("B", "Business School", 2);
        Student student3 = new Student("C", "Medical", 1);
        Student student4 = new Student("D", "Law", 2);
        Student student5 = new Student("E", "Engineering", 1);
        Student student6 = new Student("F", "Business School", 2);
        Student student7 = new Student("G", "Medical", 1);
        Student student8 = new Student("H", "Law", 2);
        Student student9 = new Student("I", "Engineering", 1);
        Student student10 = new Student("J", "Business School", 2);

        List<Student> studentList = List.of(student1, student2, student3, student4, student5, student6,
                student7, student8, student9, student10);

        Map<FacultyAndYearPair, List<Student>> groupedStudents = Student.groupStudentsByFacultyAndYear(studentList);
        Student.showStudentsGropedByFacultyAndYear(groupedStudents);

        System.out.println("EngineeringFaculty");
        List<Student> engineeringFaculty = Student.searchByFaculty(groupedStudents, "Engineering", 1);
        for(Student student : engineeringFaculty){
            System.out.println(student);
        }

        System.out.println("After removing all students in Engineering faculty Year 1:");

        Student.deleteStudentFromMap(groupedStudents,"A", "Engineering", 1);
        Student.deleteStudentFromMap(groupedStudents,"E", "Engineering", 1);
        Student.deleteStudentFromMap(groupedStudents,"I", "Engineering", 1);
        Student.showStudentsGropedByFacultyAndYear(groupedStudents);


    }
}
