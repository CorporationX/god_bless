package school.faang.bjs2_32525.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import school.faang.bjs2_32525.model.Student;
import school.faang.bjs2_32525.model.Subject;

import java.util.List;
import java.util.Map;


@AllArgsConstructor
@Getter
public class StudentManager {
    private Map<Student, Map<Subject, Integer>> studentsWithGradesBySubjects;
    private Map<Subject, List<Student>> studentsBySubject;
    private final StudentValidateService validateService = new StudentValidateService();

    public void removeStudentFromSubject(Subject subject, Student student) {
        validateService.validateRemoveStudentFromSubject(subject, student, studentsBySubject);

        List<Student> students = studentsBySubject.get(subject);
        students.remove(student);
    }


    public void addStudentToSubject(Subject subject, Student student) {
        validateService.validateArgsAddStudentToSubject(subject, student, studentsBySubject);

        List<Student> students = studentsBySubject.get(subject);
        students.add(student);
    }

    public void addSubjectWithStudents(Subject subject, List<Student> students) {
        validateService.validateArgsAddSubjectWithStudents(subject, students, studentsBySubject);
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

        validateService.validateArgsMethodAddStudentWithGradesBySubjects(student, gradesBySubjects, studentsWithGradesBySubjects);
        studentsWithGradesBySubjects.put(student, gradesBySubjects);
    }

    public void addSubjectWithGradesToStudent(Student student, Subject subject, int grade) {

        validateService.validateArgsAddSubjectWithGradesToStudent(student, subject, grade, studentsWithGradesBySubjects);
        Map<Subject, Integer> subjectIntegerMap = studentsWithGradesBySubjects.get(student);
        subjectIntegerMap.put(subject, grade);
    }

    public void removeStudentWithGradesBySubject(Student student) {
        validateService.validateArgsRemoveStudentWithGradesBySubject(student, studentsWithGradesBySubjects);
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

}
