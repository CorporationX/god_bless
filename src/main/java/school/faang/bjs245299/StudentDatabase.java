package school.faang.bjs245299;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class StudentDatabase {
    private final HashMap<Student, Map<Subject, Integer>> studentsGrades = new HashMap<>();
    private final HashMap<Subject, List<Student>> subjectStudents = new HashMap<>();

    public void addNewStudentAndGrades(Student student, Map<Subject, Integer> subjectsByGrade) {
        studentsGrades.put(student, subjectsByGrade);

        subjectsByGrade.forEach((subject, grade) ->
                subjectStudents.computeIfAbsent(subject, k -> new ArrayList<>()).add(student)
        );
    }

    public void addNewSubjectAndGradeToExistStudent(Subject subject, Integer grade, Student student) throws IllegalArgumentException {
        checkStudentExist(student);

        addToStudentsBySubjects(student, subject, grade);
        subjectStudents.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);
    }

    public void removeStudentWithSubjects(Student student) throws IllegalArgumentException {
        checkStudentExist(student);

        studentsGrades.remove(student);
        subjectStudents.forEach((subject, studentsList) -> studentsList.remove(student));
    }

    public void printStudentsWithGrades() {
        studentsGrades.forEach((student, grades) -> System.out.println(student + ": " + grades));
    }

    public void addNewSubjectAndStudents(Subject subject, List<Student> studentList) {
        subjectStudents.put(subject, studentList);
        if (studentList == null || studentList.isEmpty()) {
            addToStudentsBySubjects(null, subject, null);
        } else {
            studentList.forEach(student -> addToStudentsBySubjects(student, subject, null));
        }
    }

    public void addStudentToExistingSubject(Student student, Subject subject) throws IllegalArgumentException {
        checkSubjectExist(subject);

        subjectStudents.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);
        studentsGrades.computeIfAbsent(student, k -> new HashMap<>()).put(subject, null);
    }

    public void removeStudentFromExistingSubject(Student student, Subject subject) throws IllegalArgumentException {
        checkSubjectExist(subject);

        subjectStudents.computeIfAbsent(subject, k -> new ArrayList<>()).remove(student);
        studentsGrades.computeIfAbsent(student, k -> new HashMap<>()).remove(subject);
    }

    public void printSubjectStudents() {
        subjectStudents.forEach((subject, studentsList) -> System.out.println(subject + ": " + studentsList));
    }

    private void addToStudentsBySubjects(Student student, Subject subject, Integer grade) {
        studentsGrades.computeIfAbsent(student, k -> new HashMap<>()).put(subject, grade);
    }

    private void checkStudentExist(Student student) {
        if (!studentsGrades.containsKey(student)
                && subjectStudents.entrySet().stream()
                .noneMatch(entry -> entry.getValue().contains(student))) {
            throw new IllegalArgumentException("Student does not exist");
        }
    }

    private void checkSubjectExist(Subject subject) {
        if (!subjectStudents.containsKey(subject)
                && studentsGrades.entrySet().stream()
                .noneMatch(studentMapEntry -> studentMapEntry.getValue().containsKey(subject))) {
            throw new IllegalArgumentException("Subject does not exist");
        }
    }
}
