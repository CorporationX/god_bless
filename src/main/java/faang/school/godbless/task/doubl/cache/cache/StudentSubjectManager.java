package faang.school.godbless.task.doubl.cache.cache;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
public class StudentSubjectManager {
    private final Map<Student, Map<Subject, Integer>> studentAndCoursesGradesMap;
    private final Map<Subject, List<Student>> subjectAndStudentsListMap;

    public void addNewStudentAndCoursesGrades(Student student, Map<Subject, Integer> subjectAndGradesMap) {
        studentValidOrNullPointerExceptionThrow(student);
        subjectAndGradeMapValidOrNullPointerExceptionThrow(subjectAndGradesMap);
        if (studentAndCoursesGradesMap.containsKey(student)) {
            studentAlreadyExistExceptionThrow(student);
        }
        studentAndCoursesGradesMap.put(student, subjectAndGradesMap);
    }

    public void addSubjectAndGradeIntoExistingStudent(Student student, Subject subject, int grade) {
        studentValidOrNullPointerExceptionThrow(student);
        subjectValidOrNullPointerExceptionThrow(subject);
        if (!studentAndCoursesGradesMap.containsKey(student)) {
            studentNotFoundExceptionThrow(student);
        }
        studentAndCoursesGradesMap.get(student).put(subject, grade);
    }

    public void deleteStudentAndSubjectsWithGraduate(Student student) {
        studentValidOrNullPointerExceptionThrow(student);
        if (!studentAndCoursesGradesMap.containsKey(student)) {
            studentNotFoundExceptionThrow(student);
        }
        studentAndCoursesGradesMap.remove(student);
    }

    public void printAllStudentsAndGraduateOfSubjects() {
        if (studentAndCoursesGradesMap.isEmpty()) {
            System.out.println("Список студентов и оценок по предметам пуст");
        }
        studentAndCoursesGradesMap.entrySet().forEach(studentMapEntry -> {
            System.out.println("Ученик: " + studentMapEntry.getKey() +
                    "\nСписок предметов с оценками:");
            studentMapEntry.getValue().entrySet().forEach(subjectIntegerEntry -> {
                System.out.println("Предмет: " + subjectIntegerEntry.getKey() +
                        ", оценка: " + subjectIntegerEntry.getValue());
            });
        });
    }


    public void addNewSubjectAndStudentsList(Subject subject, List<Student> students) {
        subjectValidOrNullPointerExceptionThrow(subject);
        studentsListValidOrThrowNullPointerException(students);
        if (subjectAndStudentsListMap.containsKey(subject)) {
            subjectAlreadyExistException(subject);
        }
        subjectAndStudentsListMap.put(subject, students);
    }

    public void addStudentIntoExistingSubject(Subject subject, Student student) {
        subjectValidOrNullPointerExceptionThrow(subject);
        studentValidOrNullPointerExceptionThrow(student);
        if (!subjectAndStudentsListMap.containsKey(subject)) {
            subjectNotFoundException(subject);
        }
        var students = subjectAndStudentsListMap.get(subject);
        if (students.contains(student)) {
            studentAlreadyExistExceptionThrow(student);
        }
        students.add(student);
    }

    public void deleteStudentInSubjectAndStudentsList(Subject subject, Student student) {
        subjectValidOrNullPointerExceptionThrow(subject);
        studentValidOrNullPointerExceptionThrow(student);
        if (!subjectAndStudentsListMap.containsKey(subject)) {
            subjectNotFoundException(subject);
        }
        var students = subjectAndStudentsListMap.get(subject);
        if (!students.contains(student)) {
            studentNotFoundExceptionThrow(student);
        }
        students.remove(student);
    }

    public void printAllSubjectsAndStudents() {
        if (subjectAndStudentsListMap.isEmpty()) {
            System.out.println("Список предметов и студентов пуст");
        }
        subjectAndStudentsListMap.entrySet().forEach(subjectListEntry -> {
            System.out.println("Предмет: " + subjectListEntry.getKey() +
                    "\nУченики: ");
            subjectListEntry.getValue().forEach(student -> {
                System.out.println(student);
            });
        });
    }


    private void studentValidOrNullPointerExceptionThrow(Student student) {
        if (student == null) {
            throw new NullPointerException("Студент не может быть null");
        }
    }

    private void subjectValidOrNullPointerExceptionThrow(Subject subject) {
        if (subject == null) {
            throw new NullPointerException("Предет не может быть null");
        }
    }

    private void subjectAndGradeMapValidOrNullPointerExceptionThrow(
            Map<Subject, Integer> subjectIntegerMap) {
        if (subjectIntegerMap == null) {
            throw new NullPointerException("Список предметов с оценками не может быть null");
        }
    }

    private void studentAlreadyExistExceptionThrow(Student student) {
        throw new IllegalArgumentException("Студент %s уже добавлен в список".formatted(student));
    }

    private void studentNotFoundExceptionThrow(Student student) {
        throw new NoSuchElementException("Студент %s не найден".formatted(student));
    }

    private void studentsListValidOrThrowNullPointerException(List<Student> students) {
        if (students == null || students.isEmpty()) {
            throw new NullPointerException("Список студентов не может быть null или пустым");
        }
    }

    private void subjectAlreadyExistException(Subject subject) {
        throw new IllegalArgumentException("Предмет %s уже есть в списке".formatted(subject));
    }

    private void subjectNotFoundException(Subject subject) {
        throw new NoSuchElementException("Предмет %s не найден в списке".formatted(subject));
    }
}
