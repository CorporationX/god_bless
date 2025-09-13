package school.faang.bjs2_87078;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentDatabase {
    private static final int MIN_SUBJECT_GRADE = 2;
    private static final int MAX_SUBJECT_GRADE = 5;
    private static final int DEFAULT_SUBJECT_GRADE = 0;

    private final Map<Student, Map<Subject, Integer>> studentSubjects = new HashMap<>();
    private final Map<Subject, List<Student>> subjectStudents = new HashMap<>();

    public void addStudentWithSubjects(String studentName, String subjectName, int assessment) {
        validateStudent(studentName);
        validateSubject(subjectName);
        validateAssessment(assessment);

        Student newStudent = new Student(studentName.trim());
        Subject newSubject = new Subject(subjectName.trim());

        studentSubjects.computeIfAbsent(newStudent, k -> new HashMap<>()).put(newSubject, assessment);

        List<Student> students = subjectStudents.computeIfAbsent(newSubject, k -> new ArrayList<>());
        if (!students.contains(newStudent)) {
            students.add(newStudent);
        }
    }

    public void assignGradeToStudentSubject(String studentName, String subjectName, int assessment) {
        validateStudent(studentName);
        validateSubject(subjectName);
        validateAssessment(assessment);

        Student newStudent = new Student(studentName.trim());
        Subject newSubject = new Subject(subjectName.trim());

        if (studentSubjects.containsKey(newStudent)) {
            studentSubjects.get(newStudent).put(newSubject, assessment);
            List<Student> students = subjectStudents.computeIfAbsent(newSubject, k -> new ArrayList<>());
            if (!students.contains(newStudent)) {
                students.add(newStudent);
            }
        } else {
            System.out.println("Такого студента не существует.");
        }
    }

    public void deleteStudentWithSubjects(String studentName) {
        validateStudent(studentName);
        Student studentToRemove = new Student(studentName.trim());

        Map<Subject, Integer> subjects = studentSubjects.remove(studentToRemove);
        if (subjects != null) {
            for (Subject subject : subjects.keySet()) {
                List<Student> students = subjectStudents.get(subject);
                if (students != null) {
                    students.remove(studentToRemove);
                    if (students.isEmpty()) {
                        subjectStudents.remove(subject);
                    }
                }
            }
            System.out.println("Студент " + studentName + " удален.");
        } else {
            System.out.println("Студент не найден.");
        }
    }

    public void printAllStudentsWithGrades() {
        if (studentSubjects.isEmpty()) {
            System.out.println("База данных студентов пуста.\n");
            return;
        }

        System.out.println("--- СТУДЕНТЫ И ИХ ОЦЕНКИ ---");
        for (Map.Entry<Student, Map<Subject, Integer>> entry : studentSubjects.entrySet()) {
            System.out.printf("Студент: %s%n", entry.getKey().getName());
            for (Map.Entry<Subject, Integer> subjectGradeEntry : entry.getValue().entrySet()) {
                System.out.printf("  Предмет: %s, Оценка: %d%n",
                        subjectGradeEntry.getKey().getName(),
                        subjectGradeEntry.getValue());
            }
            System.out.println();
        }
    }

    public void addSubjectWithStudents(String subjectName, List<String> studentNames) {
        validateSubject(subjectName);

        if (studentNames == null || studentNames.isEmpty()) {
            throw new IllegalArgumentException("Список студентов не может быть пустым или null");
        }

        Subject newSubject = new Subject(subjectName.trim());
        List<Student> students = new ArrayList<>();

        for (String studentName : studentNames) {
            validateStudent(studentName);
            Student student = new Student(studentName.trim());
            students.add(student);

            studentSubjects.computeIfAbsent(student, k -> new HashMap<>())
                    .putIfAbsent(newSubject, DEFAULT_SUBJECT_GRADE);
        }

        subjectStudents.put(newSubject, students);
        System.out.println("Предмет " + subjectName + " добавлен с " + students.size() + " студентами.");
    }

    public void addStudentToSubject(String studentName, String subjectName) {
        validateStudent(studentName);
        validateSubject(subjectName);

        Student newStudent = new Student(studentName.trim());
        Subject newSubject = new Subject(subjectName.trim());

        if (!subjectStudents.containsKey(newSubject)) {
            System.out.println("Предмет " + subjectName + " не найден.");
            return;
        }

        List<Student> students = subjectStudents.get(newSubject);
        if (!students.contains(newStudent)) {
            students.add(newStudent);
            studentSubjects.computeIfAbsent(newStudent, k -> new HashMap<>())
                    .putIfAbsent(newSubject, DEFAULT_SUBJECT_GRADE);
            System.out.println("Студент " + studentName + " добавлен к предмету " + subjectName);
        } else {
            System.out.println("Студент " + studentName + " уже изучает предмет " + subjectName);
        }
    }

    public void removeStudentFromSubject(String studentName, String subjectName) {
        validateStudent(studentName);
        validateSubject(subjectName);

        Student student = new Student(studentName.trim());
        Subject subject = new Subject(subjectName.trim());

        List<Student> students = subjectStudents.get(subject);
        if (students != null && students.remove(student)) {
            Map<Subject, Integer> studentGrades = studentSubjects.get(student);
            if (studentGrades != null) {
                studentGrades.remove(subject);
                if (studentGrades.isEmpty()) {
                    studentSubjects.remove(student);
                }
            }

            if (students.isEmpty()) {
                subjectStudents.remove(subject);
            }

            System.out.println("Студент " + studentName + " удален из предмета " + subjectName);
        } else {
            System.out.println("Студент " + studentName + " не найден в предмете " + subjectName);
        }
    }

    public void printAllSubjectsWithStudents() {
        if (subjectStudents.isEmpty()) {
            System.out.println("База данных предметов пуста.\n");
            return;
        }

        System.out.println("--- ПРЕДМЕТЫ И СТУДЕНТЫ ---");
        for (Map.Entry<Subject, List<Student>> entry : subjectStudents.entrySet()) {
            System.out.printf("Предмет: %s%n", entry.getKey().getName());
            System.out.print("  Студенты: ");
            List<Student> students = entry.getValue();
            for (int i = 0; i < students.size(); i++) {
                System.out.print(students.get(i).getName());
                if (i < students.size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("\n");
        }
    }

    private void validateAssessment(int assessment) {
        if (assessment < MIN_SUBJECT_GRADE || assessment > MAX_SUBJECT_GRADE) {
            throw new IllegalArgumentException(String.format("Оценка должна быть от %d до %d",
                    MIN_SUBJECT_GRADE, MAX_SUBJECT_GRADE));
        }
    }

    private void validateStudent(String studentName) {
        if (studentName == null || studentName.isBlank()) {
            throw new IllegalArgumentException("Студент не может быть пустым или null.");
        }
    }

    private void validateSubject(String subjectName) {
        if (subjectName == null || subjectName.isBlank()) {
            throw new IllegalArgumentException("Предмет не может быть пустым или null.");
        }
    }
}