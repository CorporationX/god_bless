package faang.school.godbless.java_sql.task_3;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        var firstStudent = new Student("Иван Иванов", "Компьютерные науки", "Второй курс");
        var secondStudent = new Student("Анна Петрова", "Компьютерные науки", "Второй курс");
        var thirdStudent = new Student("Сергей Сидоров", "Химия", "Третий курс");
        var fourthStudent = new Student("Елена Смирнова", "Химия", "Третий курс");
        var fifthStudent = new Student("Дмитрий Павлов", "Биология", "Четвёртый курс");

        StudentUtils.addStudent(students, firstStudent);
        StudentUtils.addStudent(students, secondStudent);
        StudentUtils.addStudent(students, thirdStudent);
        StudentUtils.addStudent(students, fourthStudent);
        StudentUtils.addStudent(students, fifthStudent);
        System.out.println("Before deletion of fifthStudent: " + students);
        StudentUtils.deleteStudent(students, fifthStudent);
        System.out.println("After deletion of fifthStudent: " + students);
        System.out.println("-----------------------------");
        HashMap<FacultyYearPair, ArrayList<Student>> studentsMap =
                StudentGrouper.groupStudentsByFacultyAndYear(students);
        StudentUtils.printGroupedStudents(studentsMap);
    }
}
