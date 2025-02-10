package school.faang.BJS2_56950;

import java.util.*;

public class StudentDatabase {

    private final Map<Student, Map<Subject, Integer>> studentSubjects = new HashMap<>();
    private final Map<Subject, List<Student>> subjectStudents = new HashMap<>();

    public void addStudentAndSubjectWithInteger(String studentName, String subjectName, int grade) {
        Student key = new Student(studentName);
        Map<Subject, Integer> value = new HashMap<>(Map.of(new Subject(subjectName), grade));

        this.studentSubjects.put(key, value);
    }

    private Student findStudentByName(String studentName) {
        for (Student student : studentSubjects.keySet()) {
            if (student.getName().equals(studentName)) {
                return student;

            }
        }

        System.out.printf("Студента с именем %s нету в списке студентов", studentName);
        return null;
    }

    public void addNewSubjectWithInteger(String studentName, String subjectName, int grade) {
        Student student = findStudentByName(studentName);

        if (student == null) {
            return;
        }

        Map<Subject, Integer> mapSubject = studentSubjects.get(student);
        mapSubject.put(new Subject(subjectName), grade);
    }

    public void deleteStudent(String studentName) {
        Student student = findStudentByName(studentName);

        if (student == null) {
            return;
        }

        studentSubjects.remove(student);
    }

    public void showStudentWithSubject() {
        getStudentSubjects().forEach((student, subjectMap) -> {
            System.out.printf("%nИмя студенда %s%n", student.getName());
            System.out.printf("Предметы:%n");
            subjectMap.forEach((subject, integer) -> {
                System.out.printf("- Предмет %-10s | Оценка: %-3s %n", subject.getName(), integer);
            });

        });
    }

    public void addNewSubjectWithStudents(Set<String> students, String subjectName) {
        Subject subject = new Subject(subjectName);
        List<Student> value = new ArrayList<>();

        students.forEach(studentName -> value.add(new Student(studentName)));
        subjectStudents.put(subject, value);
    }

    private Subject findSubjectByName(String subjectName) {
        for (Subject subject : subjectStudents.keySet()) {
            if (subject.getName().equals(subjectName)) {
                return subject;
            }
        }

        System.out.printf("Предмета с названием %s нету в subjectStudents", subjectName);
        return null;
    }

    public void addNewStudentForSubject(String studentName, String subjectName) {
        Subject subject = findSubjectByName(subjectName);

        if (subject == null) {
            return;
        }

        subjectStudents.get(subject).add(new Student(studentName));
    }

    public void deleteStudentFromSubject(String studentName, String subjectName) {
        Subject subject = findSubjectByName(subjectName);

        if (subject == null) {
            return;
        }

        subjectStudents.get(subject).remove(new Student(studentName));
    }

    public void showSubjectWithStudent() {
        subjectStudents.forEach((subject, studentList) -> {
            System.out.printf("%nПредмет: %s%n", subject.getName());
            System.out.printf("Студенты изучающий предмет:%n");
            studentList.forEach(student -> {
                System.out.printf("Имя студента: %s%n", student.getName());
            });

        });
    }

    public Map<Student, Map<Subject, Integer>> getStudentSubjects() {
        return Collections.unmodifiableMap(studentSubjects);
    }

    public Map<Subject, List<Student>> getSubjectStudents() {
        return Collections.unmodifiableMap(subjectStudents);
    }
}
