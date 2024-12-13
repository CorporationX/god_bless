package derschrank.task10.bjstwo_45209;

import java.util.Map;
import java.util.Set;

public interface StudentDatabaseInterface {
    void addStudentAndHisNotes(Student student, Map<Subject, Integer> newNote);

    void addOneNoteToStudent(Student student, Subject subject, Integer note);

    void deleteStudent(Student student);

    void printAllStudentsWithNotes();


    void addSubjectAndHisStudents(Subject subject, Set<Student> students);

    void addOneStudentToSubject(Subject subject, Student student);

    void delStudentFromSubject(Student student, Subject subject);

    void printAllSubjectsWithStudents();
}
