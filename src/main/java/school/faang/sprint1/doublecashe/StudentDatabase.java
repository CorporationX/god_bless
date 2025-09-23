package school.faang.sprint1.doublecashe;

import java.util.List;
import java.util.Map;

/**
 * Represents a storage for the Students, Subjects and Grades data.
 */
public interface StudentDatabase {

    /**
     * Adds a new student record with subjects they attend and grades info
     *
     * @param student  the student to add
     * @param subjects map of subjects and their grades
     */
    void addStudentWithGrades(Student student, Map<Subject, Integer> subjects);

    /**
     * Adds a new subject with grade for an existing student
     *
     * @param student the student
     * @param subject the subject to add
     * @param grade   the grade
     */
    void addSubjectForStudent(Student student, Subject subject, int grade);

    /**
     * Removes a student records included all their subject data from the DB
     *
     * @param student the student to remove
     */
    void removeStudent(Student student);

    /**
     * Prints all students and their grades.
     */
    String printAllStudentsWithGrades();

    /**
     * Adds a new subject with a list of students
     *
     * @param subject  the subject to add
     * @param students list of students enrolled
     */
    void addSubjectWithStudents(Subject subject, List<Student> students);

    /**
     * Adds a student to an existing subject.
     *
     * @param student the student
     * @param subject the subject
     */
    void addStudentToSubject(Student student, Subject subject);

    /**
     * Removes a stutent from a subject
     *
     * @param student the student
     * @param subject the subject
     */
    void removeStudentFromSubject(Student student, Subject subject);

    /**
     * Prints all subjects and their students enrolled.
     */
    String printAllSubjects();

}
