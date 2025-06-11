package school.faang.bjs2_80042;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        StudentDatabase studentDatabase = new StudentDatabase();
        // Студенты
        Student kirill = new Student("Кирилл");
        Student vlados = new Student("Владос");
        Student nikita = new Student("Никитка");
        Student nastya = new Student("Настя");
        Student anya = new Student("Аня");
        Student nullStudent = new Student(null);
        // Предметы
        Subject physic = new Subject("Физика");
        Subject algebra = new Subject("Алгебра");
        Subject geometry = new Subject("Геометрия");
        Subject nullSubject = new Subject(null);

        studentDatabase.addStudentInfo(kirill, Map.of(algebra, 40));
        studentDatabase.addStudentListSubject(geometry, List.of(vlados, nikita, nastya));
        studentDatabase.displayAllSubjects();
        System.out.println();
        studentDatabase.displayAllStudents();

        studentDatabase.addSubjectForStudent(vlados, geometry, 50);
        studentDatabase.addStudentToSubject(anya, physic);

        System.out.println("\nНовая инфа");
        studentDatabase.displayAllSubjects();
        System.out.println();
        studentDatabase.displayAllStudents();

        studentDatabase.removeStudentIntoSubject(anya, physic);
        studentDatabase.removeStudentInfo(anya);
    }
}
