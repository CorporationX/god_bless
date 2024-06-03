package faang.school.godbless.students;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Student> students = List.of(
                new Student("Joffrey", "Economics", 2015),
                new Student("John", "CS", 2011),
                new Student("Sergey", "Physics", 1998),
                new Student("Larey", "Physics", 1998),
                new Student("Mann", "CS", 2011),
                new Student("Liam", "Math", 2005),
                new Student("Ben", "Forensics", 2014),
                new Student("Vlad", "Math", 2005),
                new Student("Noah", "Literature", 2000),
                new Student("Mads", "Linguistics", 2014)
        );
        System.out.println("=======================================");
        System.out.println("Organizing students by faculty and year");
        System.out.println("=======================================");
        StudentOrganizer studentOrganizer = new StudentOrganizer();
        studentOrganizer.organizeStudentsByFacultyToYear(students);
        studentOrganizer.printOrganizedMap();
        System.out.println("=======================================");
        System.out.println("Adding a new student to Physics faculty");
        System.out.println("=======================================");
        studentOrganizer.addNewStudent(new Student("Steven", "Physics", 1998));
        studentOrganizer.printSingleGroup(new FacultyYearKey("Physics", 1998));
    }




}