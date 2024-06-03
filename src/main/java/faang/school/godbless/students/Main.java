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
        StudentOrganizer studentOrganizer = new StudentOrganizer();
        studentOrganizer.organizeStudentsByFacultyToYear(students);
        studentOrganizer.printOrganizedMap();
    }




}