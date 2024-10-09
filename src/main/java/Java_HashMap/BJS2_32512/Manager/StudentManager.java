package Java_HashMap.BJS2_32512.Manager;

import Java_HashMap.BJS2_32512.Student;
import Java_HashMap.BJS2_32512.Exception.StudentAlreadyExistsException;
import Java_HashMap.BJS2_32512.Exception.StudentNotFoundException;
import Java_HashMap.BJS2_32512.Subject;
import java.util.Map;

public class StudentManager {
    public static void addNewStudent(Map<Student, Map<Subject, Integer>> studentGrades, Student student, Map<Subject, Integer> subjects) throws StudentAlreadyExistsException {
        if (studentGrades.containsKey(student)) {
            throw new StudentAlreadyExistsException("Студент уже существует.");
        }
        studentGrades.put(student, subjects);
    }

    public static void removeStudent(Map<Student, Map<Subject, Integer>> studentGrades, Student student) throws StudentNotFoundException {
        if (!studentGrades.containsKey(student)) {
            throw new StudentNotFoundException("Студент не найден.");
        }
        studentGrades.remove(student);
    }

    public static void printAllStudents(Map<Student, Map<Subject, Integer>> studentGrades) {
        for (Map.Entry<Student, Map<Subject, Integer>> entry : studentGrades.entrySet()) {
            Student student = entry.getKey();
            Map<Subject, Integer> grades = entry.getValue();
            System.out.println("Студент: " + student.getName());
            for (Map.Entry<Subject, Integer> gradeEntry : grades.entrySet()) {
                Subject subject = gradeEntry.getKey();
                Integer grade = gradeEntry.getValue();
                System.out.println("  Предмет: " + subject.getName() + " Оценка: " + grade);
            }
            System.out.println();
        }
    }

    public static void addNewSubjectForExistingStudent(Map<Student, Map<Subject, Integer>> studentGrades, Student student, Subject subject, int grade) throws StudentNotFoundException {
        if (!studentGrades.containsKey(student)) {
            throw new StudentNotFoundException("Студент не найден.");
        }
        Map<Subject, Integer> subjects = studentGrades.get(student);
        subjects.put(subject, grade);
    }
}