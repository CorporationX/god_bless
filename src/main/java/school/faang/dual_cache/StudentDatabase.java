package school.faang.dual_cache;

import lombok.AllArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentDatabase {

    // Хранит информацию о студентах, их предметах и оценках
    private Map<Student, Map<Subject, Integer>> studentSubjects;
    // Хранит информацию о предметах и списке студентов, изучающих каждый предмет
    private Map<Subject, List<Student>> subjectStudents;

    public StudentDatabase() {

        studentSubjects = new HashMap<Student, Map<Subject, Integer>>();
        subjectStudents = new HashMap<Subject, List<Student>>();
    }

    // Эти две мапы должны быть согласованными: данные об одном и том же
    // студенте или предмете в обеих мапах должны обновляться одновременно.

    // 4.1
    void addNewStudentWithGrades(Student student, Map<Subject, Integer> grades) {

        if (subjectStudents.containsKey(student)) {

            System.out.println("This student already exists");
        } else {
            System.out.println("New student is added");
            studentSubjects.put(student, grades);
        }

    }

    // 4.2
    void addSubjectForStudent(Student student, Subject subject, int grade) {

    }

    // 4.3
    void removeStudent(Student student) {

    }

    // 4.4
    void printAllSubjectsWithStudents() {

    }

    // 5.1
    void addSubjectWithStudents() {

    }

    // 5.2
    void addSubjectWithStudents(Subject subject, List<Student> students) {

    }

    // 5.3
    void addStudentToSubject(Student student, Subject subject) {

    }

    // 5.4
    void removeStudentFromSubject(Student student, Subject subject) {

    }
}
