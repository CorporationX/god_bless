package school.faang.bjs2_32525;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@AllArgsConstructor
public class StudentManager {
    private Map<Student, Map<Subject, Integer>> studentsWithGradesBySubjects;
    private Map<Subject, List<Student>> studentsBySubject;

    public void removeStudentFromSubject(Subject subject, Student student) {
        validateRemoveStudentFromSubject(subject, student);

        List<Student> students = studentsBySubject.get(subject);
        students.remove(student);
    }


    public void addStudentToSubject(Subject subject, Student student) {
        validateArgsAddStudentToSubject(subject, student);

        List<Student> students = studentsBySubject.get(subject);
        students.add(student);
    }

    public void addSubjectWithStudents(Subject subject, List<Student> students) {
        validateArgsAddSubjectWithStudents(subject, students);
        studentsBySubject.put(subject, students);
    }

    public void printAllStudentsBySubjects() {
        for (Map.Entry<Subject, List<Student>> subjectListEntry : studentsBySubject.entrySet()) {
            System.out.println(subjectListEntry.getKey().getName() + ":");

            List<Student> students = subjectListEntry.getValue();
            for (Student student : students) {
                System.out.println(student);
            }
            System.out.println();
        }
        System.out.println();
    }


    public void addStudentWithGradesBySubjects(Student student, Map<Subject, Integer> gradesBySubjects) {

        validateArgsMethodAddStudentWithGradesBySubjects(student, gradesBySubjects);
        studentsWithGradesBySubjects.put(student, gradesBySubjects);
    }

    public void addSubjectWithGradesToStudent(Student student, Subject subject, int grade) {

        validateArgsAddSubjectWithGradesToStudent(student, subject, grade);
        Map<Subject, Integer> subjectIntegerMap = studentsWithGradesBySubjects.get(student);
        subjectIntegerMap.put(subject, grade);
    }

    public void removeStudentWithGradesBySubject(Student student) {
        validateArgsRemoveStudentWithGradesBySubject(student);
        studentsWithGradesBySubjects.remove(student);
    }

    public void printAllStudentsWithGradesBySubjects() {
        if (studentsWithGradesBySubjects == null) {
            throw new IllegalArgumentException("students with grades by subjects map is null");
        }
        for (Map.Entry<Student, Map<Subject, Integer>> studentMapEntry : studentsWithGradesBySubjects.entrySet()) {
            System.out.println(studentMapEntry.getKey() + ":");
            Map<Subject, Integer> gradesBySubjects = studentMapEntry.getValue();

            for (Map.Entry<Subject, Integer> subjectIntegerEntry : gradesBySubjects.entrySet()) {
                System.out.println(subjectIntegerEntry.getKey().getName() + " = " + subjectIntegerEntry.getValue());
            }
            System.out.println();
        }
        System.out.println();
    }

    private void validateArgsRemoveStudentWithGradesBySubject(Student student) {
        if (student == null) {
            throw new IllegalArgumentException("student is null");
        }
        if (studentsWithGradesBySubjects == null) {
            throw new IllegalArgumentException("students with grades by subjects map is null");
        }

    }

    private void validateArgsAddSubjectWithGradesToStudent(Student student, Subject subject, int grade) {
        if (student == null) {
            throw new IllegalArgumentException("student is null");
        }
        if (studentsWithGradesBySubjects == null) {
            throw new IllegalArgumentException("students with grades by subjects map is null");
        }
        if (!(studentsWithGradesBySubjects.containsKey(student))) {
            throw new NoSuchElementException("there is no such student in the map yet");
        }
        Map<Subject, Integer> subjectIntegerMap = studentsWithGradesBySubjects.get(student);
        if (subjectIntegerMap.containsKey(subject)) {
            throw new IllegalArgumentException("there is already such a subject");
        }
        if (subject == null) {
            throw new IllegalArgumentException("subject is null");
        }
        int minGrade = 2;
        if (grade < minGrade) {
            throw new IllegalArgumentException("grade cannot be less than or equal to zero");
        }
        int maxGrade = 5;
        if (grade > maxGrade) {
            throw new IllegalArgumentException("grade cannot be higher than the maximum score = " + maxGrade);
        }

    }

    private void validateArgsMethodAddStudentWithGradesBySubjects(Student student, Map<Subject, Integer> gradesBySubjects) {
        if (student == null) {
            throw new IllegalArgumentException("student is null");
        }
        if (gradesBySubjects == null) {
            throw new IllegalArgumentException("grades by subjects map is null");
        }
        if (gradesBySubjects.isEmpty()) {
            throw new IllegalArgumentException("grades by subjects map is empty");
        }
        if (studentsWithGradesBySubjects == null) {
            throw new IllegalArgumentException("students with grades by subjects map is null");
        }
        if (studentsWithGradesBySubjects.containsKey(student)) {
            throw new IllegalArgumentException("there is already such a student");
        }
    }

    private void validateArgsAddSubjectWithStudents(Subject subject, List<Student> students) {
        if (subject == null) {
            throw new IllegalArgumentException("subject is null");
        }
        if (students == null) {
            throw new IllegalArgumentException("students is null");
        }
        if (students.isEmpty()) {
            throw new IllegalArgumentException("students is empty");
        }
        if (studentsBySubject == null) {
            throw new IllegalArgumentException("students by subject is null");
        }
        if (studentsBySubject.containsKey(subject)) {
            throw new IllegalArgumentException("there is already such a subject");
        }
    }

    private void validateArgsAddStudentToSubject(Subject subject, Student student) {
        if (subject == null) {
            throw new IllegalArgumentException("subject is null");
        }
        if (student == null) {
            throw new IllegalArgumentException("student is null");
        }
        if (studentsBySubject == null) {
            throw new IllegalArgumentException("students by subject is null");
        }
        if (!(studentsBySubject.containsKey(subject))) {
            throw new NoSuchElementException("there is no such subject");
        }
        List<Student> students = studentsBySubject.get(subject);
        if (students.contains(student)) {
            throw new IllegalArgumentException("such a student is already on the list");
        }
    }

    private void validateRemoveStudentFromSubject(Subject subject, Student student) {
        if (student == null) {
            throw new IllegalArgumentException("student is null");
        }
        if (subject == null) {
            throw new IllegalArgumentException("subject is null");
        }
        if (studentsBySubject == null) {
            throw new IllegalArgumentException("studentsBySubject is null");
        }
    }
}
