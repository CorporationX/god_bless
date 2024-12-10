package school.faang.bjs245254.repository;

import school.faang.bjs245254.model.Student;
import school.faang.bjs245254.model.Subject;

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