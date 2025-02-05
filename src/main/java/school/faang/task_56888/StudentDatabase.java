package school.faang.dual_cache;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class StudentDatabase {

    // Хранит информацию о студентах, их предметах и оценках
    private final Map<Student, Map<Subject, Integer>> studentSubjects;
    // Хранит информацию о предметах и списке студентов, изучающих каждый предмет
    private final Map<Subject, List<Student>> subjectStudents;

    public StudentDatabase() {

        studentSubjects = new HashMap<Student, Map<Subject, Integer>>();
        subjectStudents = new HashMap<Subject, List<Student>>();
    }

    // Эти две мапы должны быть согласованными: данные об одном и том же
    // студенте или предмете в обеих мапах должны обновляться одновременно.

    void updateSubjectStudentsFromStudentSubjects() {

        for (Map.Entry<Student, Map<Subject, Integer>> entry : studentSubjects.entrySet()) {

            Student student = entry.getKey();
            Map<Subject, Integer> subjectMap = entry.getValue();

            for (Map.Entry<Subject, Integer> entry1 : subjectMap.entrySet()) {
                Subject subject = entry1.getKey();

                updateSubjectStudents(student, subject);
            }
        }
    }

    void updateSubjectStudents(Student student, Subject subject) {

        if (subjectStudents.containsKey(subject)) {
            var lstStudents = subjectStudents.get(subject);
            if (lstStudents != null) {
                if (!lstStudents.contains(student)) {
                    lstStudents.add(student);
                    subjectStudents.put(subject, lstStudents);
                }
            } else {
                lstStudents = new ArrayList<Student>();
                lstStudents.add(student);
                subjectStudents.put(subject, lstStudents);
            }
        } else {
            var lstStudents = new ArrayList<Student>();
            lstStudents.add(student);
            subjectStudents.put(subject, lstStudents);
        }
    }

    // 4.1
    void addNewStudentWithGrades(Student student, Map<Subject, Integer> grades) {

        if (studentSubjects.containsKey(student)) {
            System.out.println("This student already exists");
        } else {
            studentSubjects.put(student, grades);
            System.out.println("New student is added");
        }

        for (Map.Entry<Subject, Integer> entry : grades.entrySet()) {
            Subject subject = entry.getKey();

            updateSubjectStudents(student, subject);
        }
    }

    // 4.2
    void addSubjectForStudent(Student student, Subject subject, int grade) {

        if (studentSubjects.containsKey(student)) {
            var mapSubjects = studentSubjects.get(student);
            if (mapSubjects.containsKey(subject)) {
                var oldGrade = mapSubjects.get(subject);
                if (oldGrade != grade) {
                    mapSubjects.put(subject, grade);
                }
            } else {
                mapSubjects.put(subject, grade);
            }
            studentSubjects.put(student, mapSubjects);

        } else {
            System.out.println("There is not such student in database");
        }

        updateSubjectStudents(student, subject);
    }

    // 4.3
    void removeStudent(Student student) {

        studentSubjects.remove(student);

        for (Map.Entry<Subject, List<Student>> entry : subjectStudents.entrySet()) {

            Subject subject = entry.getKey();
            var list = subjectStudents.get(subject);

            if (list != null) {
                if (list.contains(student)) {
                    list.remove(student);
                }
            }

            subjectStudents.put(subject, list);
        }
    }

    // 4.4
    void printAllStudentsWithSubjectsAndGrades() {

        for (Map.Entry<Student, Map<Subject, Integer>> entry : studentSubjects.entrySet()) {

            Student student = entry.getKey();
            var value = entry.getValue();

            System.out.println(student.getName());

            for (Map.Entry<Subject, Integer> entry1 : value.entrySet()) {

                Subject subject = entry1.getKey();
                System.out.println("--- " + subject.getName() + ": " + entry1.getValue());
            }
        }
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
    void printAllSubjectsWithStudents() {

    }
}
