package school.faang.cache;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class StudentDatabase {

    private final Map<Student, Map<Subject, Integer>> studentSubjects = new HashMap<>();
    private final Map<Subject, Set<Student>> subjectStudents = new HashMap<>();

    public void addStudentWithGrade(Student currentStudent, List<GradedItem> gradedItems) {
        Map<Subject, Integer> currentStudentGrade = studentSubjects.getOrDefault(currentStudent,
                new HashMap<>());
        for (GradedItem gradedItem : gradedItems) {
            Subject currentSubject = new Subject(gradedItem.subjectName());
            currentStudentGrade.put(currentSubject, gradedItem.mark());
            addStudentToSubjects(currentStudent, currentSubject);
        }
        studentSubjects.put(currentStudent, currentStudentGrade);
    }

    public void addStudentToSubjects(Student student, Subject subject) {
        subjectStudents.computeIfAbsent(subject, sub -> new HashSet<>())
                .add(student);
    }

    public void addSubjectWithStudents(Subject currentSubject, List<String> studentNames) {
        Set<Student> studentBySubject = subjectStudents.getOrDefault(currentSubject, new HashSet<>());
        for (String studentName : studentNames) {
            Student currentStudent = new Student(studentName);
            studentBySubject.add(currentStudent);
            addSubjectToStudentGrade(currentStudent, currentSubject);
        }
        subjectStudents.put(currentSubject, studentBySubject);
    }

    public void addSubjectToStudentGrade(Student student, Subject subject) {
        studentSubjects.computeIfAbsent(student,
                s -> new HashMap<>()).putIfAbsent(subject, 0);
    }

    public void deleteStudent(Student studentForDeleting) {
        Set<Subject> subjectByStudent = studentSubjects.getOrDefault(studentForDeleting,
                Collections.emptyMap()).keySet();
        deleteStudentFromSubjects(studentForDeleting, subjectByStudent);
        studentSubjects.remove(studentForDeleting);
    }

    public void deleteStudentFromSubjects(Student studentForDeleting, Set<Subject> subjectByStudent) {
        subjectByStudent.forEach(subject -> {
            Set<Student> studentBySubject = subjectStudents.getOrDefault(subject,
                    Collections.emptySet());
            if (!studentBySubject.isEmpty()) {
                studentBySubject.remove(studentForDeleting);
            }
        });
    }

    public void deleteStudentFromSubject(Student studentForDeleting, Subject currentSubject) {
        deleteSubjectFromGrade(studentForDeleting, currentSubject);
        Set<Student> studentBySubject = subjectStudents.getOrDefault(currentSubject, Collections.emptySet());
        if (!studentBySubject.isEmpty()) {
            studentBySubject.remove(studentForDeleting);
        }
    }

    private void deleteSubjectFromGrade(Student studentForDeleting, Subject currentSubject) {
        Map<Subject, Integer> gradeForDeleting = studentSubjects.getOrDefault(studentForDeleting,
                Collections.emptyMap());
        if (!gradeForDeleting.isEmpty()) {
            gradeForDeleting.remove(currentSubject);
        }
    }

    public void printStudentWithGrade() {
        studentSubjects.forEach((student, grade) -> {
            System.out.println(student.getName() + ": ");
            grade.forEach((subject, mark) -> {
                System.out.println(subject + " " + mark + " ");
            });
            System.out.println();
        });
    }

    public void printSubjectWithStudents() {
        subjectStudents.forEach((subject, students) -> {
            System.out.println(subject + ": " + students);
        });
    }
}
