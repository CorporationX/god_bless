package school.faang.doublecachecache;


public class UniversityManagerService {
    public static void addStudentAndSubject(Student student, String subjectName, int grade) {
        StudentService.addNewStudent(student, subjectName, grade);
        SubjectService.addNewSubject(subjectName, student);
    }

    public static void addSubjectForExistingStudent(String studentName, String subjectName, int grade) {
        StudentService.addSubjectForExistStudent(studentName, subjectName, grade);
        SubjectService.addStudentForExistSubject(subjectName, new Student(studentName)); // изменить параметр в методе
    }

    public static void removeStudent(String studentName) {
        StudentService.removeStudent(studentName);
        SubjectService.removeStudent(studentName);
    }
}
