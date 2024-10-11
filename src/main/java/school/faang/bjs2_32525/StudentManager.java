package school.faang.bjs2_32525;

import java.util.Map;
import java.util.NoSuchElementException;

public class StudentManager {

    public void addStudentWithGradesBySubjects(Student student, Map<Subject, Integer> gradesBySubjects,
                                               Map<Student, Map<Subject, Integer>> studentsWithGradesBySubjects) {

        validateArgsMethodAddStudentWithGradesBySubjects(student, gradesBySubjects, studentsWithGradesBySubjects);
        studentsWithGradesBySubjects.put(student, gradesBySubjects);
    }

    public void addSubjectWithGradesToStudent(Student student, Subject subject, int grade,
                                              Map<Student, Map<Subject, Integer>> studentsWithGradesBySubjects) {

        validateAddSubjectWithGradesToStudent(student, subject, grade, studentsWithGradesBySubjects);
        Map<Subject, Integer> subjectIntegerMap = studentsWithGradesBySubjects.get(student);
        subjectIntegerMap.put(subject, grade);
    }

    public void removeStudentWithGradesBySubject(Student student, Map<Student, Map<Subject, Integer>> studentsWithGradesBySubjects) {
        validateRemoveStudentWithGradesBySubject(student, studentsWithGradesBySubjects);
        studentsWithGradesBySubjects.remove(student);
    }

    private static void validateRemoveStudentWithGradesBySubject(Student student, Map<Student, Map<Subject, Integer>> studentsWithGradesBySubjects) {
        if (student == null) {
            throw new IllegalArgumentException("student is null");
        }
        if (studentsWithGradesBySubjects == null) {
            throw new IllegalArgumentException("students with grades by subjects map is null");
        }

    }

    private static void validateAddSubjectWithGradesToStudent(Student student, Subject subject, int grade, Map<Student, Map<Subject, Integer>> studentsWithGradesBySubjects) {
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
        if (studentsWithGradesBySubjects == null) {
            throw new IllegalArgumentException("students with grades by subjects map is null");
        }
    }
}
