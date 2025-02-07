package school.faang.BJS2_56950;

import java.util.*;

public class StudentDatabase {

    private final Map<Student, Map<Subject, Integer>> studentSubjects = new HashMap<>();
    private final Map<Subject, List<Student>> subjectStudents = new HashMap<>();

    public  void addStudentAndSubjectWithInteger(String studentName, String subjectName, int integer) {
        Student key = new Student(studentName);
        Map<Subject, Integer> value = new HashMap<>(Map.of(new Subject(subjectName), integer));

        this.studentSubjects.put(key, value);
    }

    public  Student findStudent(String studentName) {
        Student student = new Student(studentName);

        if (!getStudentSubjects().containsKey(student)) {
            System.out.printf("Студента с именем %s нету в списке студентов", studentName);
            return null;
        }

        return student;
    }

    public  void addNewSubjectWithInteger(String studentName, String subjectName, int integer) {
        Student student = findStudent(studentName);

        if (student == null) {
            return;
        }

        Map<Subject, Integer> mapSubject = studentSubjects.get(student);
        mapSubject.put(new Subject(subjectName), integer);
    }

    public  void deleteStudent(String studentName) {
        Student student = findStudent(studentName);

        if (student == null) {
            return;
        }

        studentSubjects.remove(student);
    }

    public  void showStudentWithSubject() {
        getStudentSubjects().forEach((student, subjectMap) -> {
            System.out.printf("%nИмя студенда %s%n", student.getName());
            System.out.printf("Предметы:%n");
            subjectMap.forEach((subject, integer) -> {
                System.out.printf("- Предмет %-10s | Оценка: %-3s %n", subject.getName(), integer);
            });

        });
    }

    public  void addNewSubjectWithStudents(Set<String> students, String subjectName) {
        Subject subject = new Subject(subjectName);
        List<Student> value = new ArrayList<>();

        students.forEach(studentName -> value.add(new Student(studentName)));
        subjectStudents.put(subject, value);
    }

    public  Subject findSubject(String subjectName) {
        Subject subject = new Subject(subjectName);

        if (!subjectStudents.containsKey(subject)) {
            System.out.printf("Предмета с названием %s нету в subjectStudents", subjectName);
            return null;
        }

        return subject;
    }

    public  void addNewStudentForSubject(String studentName, String subjectName) {
        Subject subject = findSubject(subjectName);

        if (subject == null) {
            return;
        }

        subjectStudents.get(subject).add(new Student(studentName));
    }

    public  void deleteStudentFromSubject(String studentName, String subjectName) {
        Subject subject = findSubject(subjectName);

        if (subject == null) {
            return;
        }

        subjectStudents.get(subject).remove(new Student(studentName));
    }

    public  void showSubjectWithStudent() {
        subjectStudents.forEach((subject, studentList) -> {
            System.out.printf("%nПредмет: %s%n", subject.getName());
            System.out.printf("Студенты изучающий предмет:%n");
            studentList.forEach(student -> {
                System.out.printf("Имя студента: %s%n", student.getName());
            });

        });
    }

    public  Map<Student, Map<Subject, Integer>> getStudentSubjects() {
        return Collections.unmodifiableMap(studentSubjects);
    }

    public  Map<Subject, List<Student>> getSubjectStudents() {
        return Collections.unmodifiableMap(subjectStudents);
    }
}
