package school.faang.bjs2_32525;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public class StudentManager {
    public void addStudentToSubject(Subject subject, Student student, Map<Subject, List<Student>> studentsBySubject) {
        validateArgsAddStudentToSubject(subject, student, studentsBySubject);

        List<Student> students = studentsBySubject.get(subject);
        students.add(student);

    }


    public void addSubjectWithStudents(Subject subject, List<Student> students, Map<Subject, List<Student>> studentsBySubject) {
        validateArgsAddSubjectWithStudents(subject, students, studentsBySubject);
        studentsBySubject.put(subject, students);
    }

    public void printAllStudentsBySubjects(Map<Subject, List<Student>> studentsBySubject) {
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


    public void addStudentWithGradesBySubjects(Student student, Map<Subject, Integer> gradesBySubjects,
                                               Map<Student, Map<Subject, Integer>> studentsWithGradesBySubjects) {

        validateArgsMethodAddStudentWithGradesBySubjects(student, gradesBySubjects, studentsWithGradesBySubjects);
        studentsWithGradesBySubjects.put(student, gradesBySubjects);
    }

    public void addSubjectWithGradesToStudent(Student student, Subject subject, int grade,
                                              Map<Student, Map<Subject, Integer>> studentsWithGradesBySubjects) {

        validateArgsAddSubjectWithGradesToStudent(student, subject, grade, studentsWithGradesBySubjects);
        Map<Subject, Integer> subjectIntegerMap = studentsWithGradesBySubjects.get(student);
        subjectIntegerMap.put(subject, grade);
    }

    public void removeStudentWithGradesBySubject(Student student, Map<Student, Map<Subject, Integer>> studentsWithGradesBySubjects) {
        validateArgsRemoveStudentWithGradesBySubject(student, studentsWithGradesBySubjects);
        studentsWithGradesBySubjects.remove(student);
        //TODO: удалить если последний студент был удален
    }

    public void printAllStudentsWithGradesBySubjects(Map<Student, Map<Subject, Integer>> studentsWithGradesBySubjects) {
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

    private static void validateArgsRemoveStudentWithGradesBySubject(Student student, Map<Student, Map<Subject, Integer>> studentsWithGradesBySubjects) {
        if (student == null) {
            throw new IllegalArgumentException("student is null");
        }
        if (studentsWithGradesBySubjects == null) {
            throw new IllegalArgumentException("students with grades by subjects map is null");
        }

    }

    private static void validateArgsAddSubjectWithGradesToStudent(Student student, Subject subject, int grade, Map<Student, Map<Subject, Integer>> studentsWithGradesBySubjects) {
        if (student == null) {
            throw new IllegalArgumentException("student is null");
        }
        if (studentsWithGradesBySubjects == null) {
            throw new IllegalArgumentException("students with grades by subjects map is null");
        }
        if (!(studentsWithGradesBySubjects.containsKey(student))) {
            throw new NoSuchElementException("there is no such student in the map yet");
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

    private static void validateArgsMethodAddStudentWithGradesBySubjects(Student student, Map<Subject, Integer> gradesBySubjects, Map<Student, Map<Subject, Integer>> studentsWithGradesBySubjects) {
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
    }

    private static void validateArgsAddSubjectWithStudents(Subject subject, List<Student> students, Map<Subject, List<Student>> studentsBySubject) {
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
    }

    private static void validateArgsAddStudentToSubject(Subject subject, Student student, Map<Subject, List<Student>> studentsBySubject) {
        if (subject == null) {
            throw new IllegalArgumentException("subject is null");
        }
        if (student == null) {
            throw new IllegalArgumentException("student is null");
        }
        if (studentsBySubject == null) {
            throw new IllegalArgumentException("students by subject is null");
        }
    }
}
