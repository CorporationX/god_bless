package school.faang.task_45206;

import java.util.Map;
import java.util.Set;

public interface StudentProvider {
    void addStudentWithGrades(Student student, Map<Subject, Integer> subjectsGrades);

    void addSubjectForStudent(Student student, Subject subject, Integer grade);

    void deleteStudent(Student student);

    void printAllStudentsWithSubjects();

    void addSubjectWithStudents(Subject subject, Set<Student> students);

    void addStudentForSubject(Subject subject, Student student);

    void deleteStudentFromSubject(Subject subject, Student student);

    void printAllSubjectsWithStudents();
}
