package school.faang.bjs2_32525;

import java.util.Map;

public class StudentManager {

    public void addStudentWithGradesBySubjects(Student student, Map<Subject, Integer> gradesBySubjects,
                                               Map<Student, Map<Subject, Integer>> studentsWithGradesBySubjects) {

        validateArgsMethodAddStudentWithGradesBySubjects(student, gradesBySubjects, studentsWithGradesBySubjects);
        studentsWithGradesBySubjects.put(student, gradesBySubjects);
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
