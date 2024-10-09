package Java_HashMap.BJS2_32512;

import Java_HashMap.BJS2_32512.Exception.StudentAlreadyExistsException;
import Java_HashMap.BJS2_32512.Exception.StudentNotFoundException;
import Java_HashMap.BJS2_32512.Manager.StudentManager;
import Java_HashMap.BJS2_32512.Manager.SubjectManager;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Создаем студентов
        Student student1 = new Student(1, "Alice");
        Student student2 = new Student(2, "Bob");
        Student student3 = new Student(3, "Charlie");

        // Создаем предметы
        Subject math = new Subject(1, "Math");
        Subject physics = new Subject(2, "Physics");
        Subject chemistry = new Subject(3, "Chemistry");

        // Первая HashMap: студенты и их оценки по предметам
        Map<Student, Map<Subject, Integer>> studentGrades = new HashMap<>();
        studentGrades.put(student1, Map.of(math, 85, physics, 90));
        studentGrades.put(student2, Map.of(math, 75, chemistry, 80));
        studentGrades.put(student3, Map.of(physics, 88, chemistry, 92));

        // Вторая HashMap: предметы и списки студентов, изучающих данные предметы
        Map<Subject, List<Student>> subjectStudents = new HashMap<>();
        subjectStudents.computeIfAbsent(math, k -> new ArrayList<>()).add(student1);
        subjectStudents.computeIfAbsent(math, k -> new ArrayList<>()).add(student2);
        subjectStudents.computeIfAbsent(physics, k -> new ArrayList<>()).add(student1);

        try {
            // Логика работы с студентами
            StudentManager.addNewStudent(studentGrades, student3, Map.of(math, 95, chemistry, 88));
            StudentManager.addNewSubjectForExistingStudent(studentGrades, student1, chemistry, 95);
            StudentManager.removeStudent(studentGrades, student2);
            StudentManager.printAllStudents(studentGrades);

            // Логика работы с предметами
            SubjectManager.addNewSubjectAndStudents(subjectStudents, chemistry, List.of(student2, student3));
            SubjectManager.addStudentToExistingSubject(subjectStudents, math, student3);
            SubjectManager.removeStudentFromSubject(subjectStudents, math, student2);
            SubjectManager.printAllSubjects(subjectStudents);
        } catch (StudentAlreadyExistsException | StudentNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
