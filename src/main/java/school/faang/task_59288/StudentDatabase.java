package school.faang.task_59288;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
public class StudentDatabase {
    final Map<Student, Map<Subject, Integer>> studentSubjects;
    final Map<Subject, List<Student>> subjectStudents;

    public void addStudentAndGrades(String studentName, Map<Subject, Integer> subjectWithGrades) {
        Student student = new Student(studentName);
        studentSubjects.put(student, subjectWithGrades);

        for (Map.Entry<Subject, Integer> subjectEntry : subjectWithGrades.entrySet()) {
            if (!subjectStudents.containsKey(subjectEntry.getKey())) {
                subjectStudents.put(subjectEntry.getKey(), new ArrayList<>());
            }
            List<Student> studentList = subjectStudents.get(subjectEntry.getKey());
            studentList.add(student);
            subjectStudents.put(subjectEntry.getKey(), studentList);
        }
    }

    public void addSubjectForStudent(Student student, String subjectName, Integer grade) {
        Subject subject = new Subject(subjectName);
        Map<Subject, Integer> subjectWithGrades = studentSubjects.get(student);
        subjectWithGrades.put(subject, grade);

        if (!subjectStudents.containsKey(subject)) {
            subjectStudents.put(subject, new ArrayList<>());
        }
        List<Student> studentList = subjectStudents.get(subject);
        studentList.add(student);
    }

    public void deleteStudentWithSubjects(Student student) {
        studentSubjects.remove(student);

        for (Map.Entry<Subject, List<Student>> subjectStudentsMap : subjectStudents.entrySet()) {
            List<Student> studentList = subjectStudentsMap.getValue();
            studentList.remove(student);
            if (studentList.isEmpty()) {
                subjectStudents.remove(subjectStudentsMap.getKey());
            }
        }
    }

    public void printAllStudentsWithGrades() {
        for (Map.Entry<Student, Map<Subject, Integer>> studentMapEntry : studentSubjects.entrySet()) {
            Map<Subject, Integer> subjectIntegerMap = studentSubjects.get(studentMapEntry.getKey());
            System.out.println("Student: " + studentMapEntry.getKey().getName());
            for (Map.Entry<Subject, Integer> subjectGradeEntry : subjectIntegerMap.entrySet()) {
                System.out.println("\t" + subjectGradeEntry.getKey().getName() + ": "
                        + subjectGradeEntry.getValue());
            }
        }
    }

    public void createSubjectWithStudents(String subjectName, List<Student> students) {
        Subject subject = new Subject(subjectName);
        for (Map.Entry<Student, Map<Subject, Integer>> studentMapEntry : studentSubjects.entrySet()) {
            if (students.contains(studentMapEntry.getKey())) {
                studentMapEntry.getValue().put(subject, null);
            }
        }
        subjectStudents.put(subject, students);
    }

    public void enrollStudentInSubject(Student student, Subject subject) {
        Map<Subject, Integer> subjectGradesMap = new HashMap<>();
        subjectGradesMap.put(subject, null);
        studentSubjects.put(student, subjectGradesMap);

        List<Student> studentList = subjectStudents.get(subject);
        studentList.add(student);
        subjectStudents.put(subject, studentList);
    }

    public void removeStudentFromSubject(Student student, Subject subject) {
        Map<Subject, Integer> subjectGradesMap = studentSubjects.get(student);
        subjectGradesMap.remove(subject);

        List<Student> studentList = subjectStudents.get(subject);
        studentList.remove(student);
    }

    public void printAllSubjectsWithEnrolledStudents() {
        for (Map.Entry<Subject, List<Student>> subjectMapEntry : subjectStudents.entrySet()) {
            List<Student> studentList = subjectStudents.get(subjectMapEntry.getKey());
            System.out.print("Subject: " + subjectMapEntry.getKey().getName() + "\n");
            for (Student student : studentList) {
                System.out.println("\t" + student.getName());
            }
        }
    }
}
