package school.faang.doublecachecache;


import java.util.List;
import java.util.Map;
import java.util.Set;

public class UniversityManagerService {
    public static void addStudentAndSubject(Student student, String subjectName, int grade, Map<Student, Map<Subject, Integer>> students, Set<Subject> subjects, Map<Subject, List<Student>> groupedSubAndStud) {
        StudentService.addNewStudent(student, subjectName, grade, students, subjects);
        SubjectService.addNewSubject(subjectName, student, groupedSubAndStud, subjects);
    }

    public static void addSubjectForExistingStudent(String studentName, String subjectName, int grade, Map<Student, Map<Subject, Integer>> students, Set<Subject> subjects, Map<Subject, List<Student>> groupedSubAndStud) {
        StudentService.addSubjectForExistStudent(studentName, subjectName, grade, students, subjects);
        SubjectService.addStudentForExistSubject(subjectName, new Student(studentName), groupedSubAndStud, subjects);
    }

    public static void removeStudent(String studentName, Map<Student, Map<Subject, Integer>> students, Map<Subject, List<Student>> groupedSubAndStud) {
        StudentService.removeStudent(studentName, students);
        SubjectService.removeStudent(studentName, students, groupedSubAndStud);
    }
}
