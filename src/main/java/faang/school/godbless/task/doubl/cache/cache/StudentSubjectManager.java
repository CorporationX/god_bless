package faang.school.godbless.task.doubl.cache.cache;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
public class StudentSubjectManager {
    private final Map<Student, Map<Subject, Integer>> studentAndCoursesGradesMap;
    private final Map<Subject, List<Student>> subjectAndStudentsListMap;

    public void addNewStudentAndCoursesGrades(@NonNull Student student,
                                              @NonNull Map<Subject, Integer> subjectAndGradesMap) {
        if (studentAndCoursesGradesMap.containsKey(student)) {
            studentAlreadyExist(student);
        }
        studentAndCoursesGradesMap.put(student, subjectAndGradesMap);
    }

    public void addSubjectAndGradeIntoExistingStudent(@NonNull Student student,
                                                      @NonNull Subject subject, int grade) {
        if (!studentAndCoursesGradesMap.containsKey(student)) {
            studentNotFound(student);
        }
        studentAndCoursesGradesMap.get(student).put(subject, grade);
    }

    public void deleteStudentAndSubjectsWithGraduate(@NonNull Student student) {
        if (!studentAndCoursesGradesMap.containsKey(student)) {
            studentNotFound(student);
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


    public void addNewSubjectAndStudentsList(@NonNull Subject subject,
                                             @NonNull List<Student> students) {
        if (subjectAndStudentsListMap.containsKey(subject)) {
            System.out.println("Предмет %s уже есть в списке".formatted(subject));
        }
        subjectAndStudentsListMap.put(subject, students);
    }

    public void addStudentIntoExistingSubject(@NonNull Subject subject,
                                              @NonNull Student student) {
        if (!subjectAndStudentsListMap.containsKey(subject)) {
            subjectNotFound(subject);
        }
        List<Student> students = subjectAndStudentsListMap.get(subject);
        if (students.contains(student)) {
            studentAlreadyExist(student);
        }
        students.add(student);
    }

    public void deleteStudentInSubjectAndStudentsList(@NonNull Subject subject,
                                                      @NonNull Student student) {
        if (!subjectAndStudentsListMap.containsKey(subject)) {
            subjectNotFound(subject);
        }
        List<Student> students = subjectAndStudentsListMap.get(subject);
        if (!students.contains(student)) {
            studentNotFound(student);
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

    private void studentAlreadyExist(Student student) {
        System.out.println("Студент %s уже добавлен в список".formatted(student));
    }

    private void studentNotFound(Student student) {
        System.out.println("Студент %s не найден".formatted(student));
    }

    private void subjectNotFound(Subject subject) {
        System.out.println("Предмет %s не найден в списке".formatted(subject));
    }
}
