package school.faang.task_56888;

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

        if (studentSubjects.containsKey(student)) {

            System.out.println("This student already exists");
        } else {

            System.out.println("New student is added");
            studentSubjects.put(student, grades);
        }
    }

    // 4.2
    void addSubjectForStudent(Student student, Subject subject, int grade) {

        if (studentSubjects.containsKey(student)) {

            Map<Subject, Integer> subjects = studentSubjects.get(student);
            if (subjects.containsKey(subject)) {
                // Вытащить subject, проверить совпадает ли оценка,
                // если да, то ничего не делать, если нет, заменить оценку
                var res = subjects.get(subject);

                if (res.compareTo(grade) != 0) {

                }

            } else {
                // Добавить предмет и оценку, перезапивать
            }
        } else {

            System.out.println("This student does not exist");
        }
    }

    // 4.3
    void removeStudent(Student student) {

    }

    // 4.4
    void printAllStudentsWithSubjectsAndMarks(Subject subject, List<Student> students) {

    }

    // 5.1
    void addSubjectWithStudents(Subject subject, List<Student> students) {

    }

    // 5.2
    void addStudentToSubject(Student student, Subject subject) {

    }

    // 5.3
    void removeStudentFromSubject(Student student, Subject subject) {

    }

    // 5.4
    void printAllSubjectsWithStudents(Subject subject, List<Student> students) {

    }
}
