package school.faang.bjs2_32525;

import org.junit.jupiter.api.Test;
import school.faang.bjs2_32525.model.Student;
import school.faang.bjs2_32525.model.Subject;
import school.faang.bjs2_32525.service.StudentManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class StudentManagerTest {
    private final StudentManager studentManager = new StudentManager(new HashMap<>(), new HashMap<>());

    @Test
    void addSubjectWithStudents() {
        Student student = new Student("Alex");
        List<Student> students = new ArrayList<>();
        students.add(student);
        Subject subject = new Subject("Mathematics");
        studentManager.addSubjectWithStudents(subject, students);
        Map<Subject, List<Student>> studentsBySubject = studentManager.getStudentsBySubject();
        assertTrue(studentsBySubject.containsKey(subject));
        assertTrue(studentsBySubject.containsValue(students));
        studentsBySubject.clear();
    }

    @Test
    void removeStudentFromSubject() {
        Student student = new Student("Alex");
        List<Student> students = new ArrayList<>();
        students.add(student);
        Subject subject = new Subject("Mathematics");

        studentManager.addSubjectWithStudents(subject, students);
        studentManager.removeStudentFromSubject(subject, student);

        Map<Subject, List<Student>> studentsBySubject = studentManager.getStudentsBySubject();
        List<Student> studentsFromMap = studentsBySubject.get(subject);
        assertFalse(studentsFromMap.contains(student));
        studentsBySubject.clear();
    }

    @Test
    void addStudentToSubject() {
        Subject subject = new Subject("Mathematics");
        Student studentSource = new Student("Alex");
        List<Student> students = new ArrayList<>();
        students.add(studentSource);
        studentManager.addSubjectWithStudents(subject, students);
        Student studentForAdd = new Student("Alex");
        studentManager.addStudentToSubject(subject, studentForAdd);

        Map<Subject, List<Student>> studentsBySubject = studentManager.getStudentsBySubject();
        List<Student> studentsFromMap = studentsBySubject.get(subject);
        assertTrue(studentsFromMap.contains(studentForAdd));
        studentsBySubject.clear();
    }


    @Test
    void addStudentWithGradesBySubjects() {
        Student student = new Student("Alex");
        Subject subject = new Subject("Mathematics");
        int grade = 5;
        Map<Subject, Integer> gradesBySubject = new HashMap<>();
        gradesBySubject.put(subject, grade);

        studentManager.addStudentWithGradesBySubjects(student, gradesBySubject);
        Map<Student, Map<Subject, Integer>> studentsWithGradesBySubjects = studentManager.getStudentsWithGradesBySubjects();
        assertTrue(studentsWithGradesBySubjects.containsKey(student));
        assertTrue(studentsWithGradesBySubjects.containsValue(gradesBySubject));
        studentsWithGradesBySubjects.clear();
    }

    @Test
    void addSubjectWithGradesToStudent() {
        Student student = new Student("Alex");
        Subject subjectSource = new Subject("Mathematics");
        int grade = 5;
        Map<Subject, Integer> gradesBySubject = new HashMap<>();
        gradesBySubject.put(subjectSource, grade);

        studentManager.addStudentWithGradesBySubjects(student, gradesBySubject);
        Subject subjectForAdd = new Subject("Literature");
        int gradeForAdd = 5;
        studentManager.addSubjectWithGradesToStudent(student, subjectForAdd, gradeForAdd);
        Map<Student, Map<Subject, Integer>> studentsWithGradesBySubjects = studentManager.getStudentsWithGradesBySubjects();
        Map<Subject, Integer> subjectIntegerMap = studentsWithGradesBySubjects.get(student);
        assertTrue(subjectIntegerMap.containsKey(subjectForAdd));
        assertTrue(subjectIntegerMap.containsValue(gradeForAdd));
        studentsWithGradesBySubjects.clear();
    }

    @Test
    void removeStudentWithGradesBySubject() {
        Student student = new Student("Alex");
        Subject subjectSource = new Subject("Mathematics");
        int grade = 5;
        Map<Subject, Integer> gradesBySubject = new HashMap<>();
        gradesBySubject.put(subjectSource, grade);

        studentManager.addStudentWithGradesBySubjects(student, gradesBySubject);
        studentManager.removeStudentWithGradesBySubject(student);
        Map<Student, Map<Subject, Integer>> studentsWithGradesBySubjects = studentManager.getStudentsWithGradesBySubjects();
        assertFalse(studentsWithGradesBySubjects.containsKey(student));
        studentsWithGradesBySubjects.clear();
    }
}