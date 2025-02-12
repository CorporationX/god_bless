package school.faang.bjs2_57037;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@NoArgsConstructor
@Getter
public class StudentDatabase {

    private final Map<Student, Map<Subject, Integer>> studentSubjects = new HashMap<>();
    private final Map<Subject, List<Student>> subjectStudents = new HashMap<>();

    /**
     * Метод добавляет нового студента в studentSubjects и записывает для него оценки по каждому предмету.
     * Также добавляет студента к каждому предмету в subjectStudents.
     *
     * @param student объект класса Student
     * @param grades  словарь, где ключ - Предмет, а значение - оценка
     */
    public void addStudentWithGrades(Student student, Map<Subject, Integer> grades) {
        studentSubjects.put(student, grades);
        for (Subject subject : grades.keySet()) {
            subjectStudents.computeIfAbsent(subject, s ->  new ArrayList<>()).add(student);
        }
    }

    /**
     * Метод добавляет новый предмет и оценку для существующего студента.
     * Если студент отсутствует в studentSubjects, создаётся новая запись.
     */
    public void addSubjectForStudent(Student student, Subject subject, int grade) {
        studentSubjects.computeIfAbsent(student, s -> new HashMap<>()).put(subject, grade);
        subjectStudents.computeIfAbsent(subject, s -> new ArrayList<>()).add(student);
    }

    /**
     * Метод удаляет студента и все его предметы из studentSubjects,
     * а также из списков студентов для всех соответствующих предметов в subjectStudents.
     */
    public void removeStudent(Student student) {
        Map<Subject, Integer> removedGrades = studentSubjects.remove(student);
        if (removedGrades != null) {
            for (Subject subject : removedGrades.keySet()) {
                subjectStudents.get(subject).remove(student);
            }
        }
    }

    public void printAllStudentsWithGrades() {
        studentSubjects.forEach((student, grades) -> {
            System.out.println("Студент: " + student);
            for (Subject subject : grades.keySet()) {
                System.out.println(subject + " : " + grades.get(subject));
            }
        });
    }

    /**
     * Метод добавляет новый предмет и список студентов, изучающих его.
     *
     * @param subject  предмет
     * @param students список студентов
     */
    public void addSubjectWithStudents(Subject subject, List<Student> students) {
        subjectStudents.put(subject, students);
        for (Student student : students) {
            studentSubjects.computeIfAbsent(student, s -> new HashMap<>()).put(subject, null);
        }
    }

    /**
     * Добавление студента к существующему предмету.
     * Если предмет или студент отсутствуют, создаются соответствующие записи.
     */
    public void addStudentToSubject(Student student, Subject subject) {
        subjectStudents.computeIfAbsent(subject, s -> new ArrayList<>()).add(student);
        studentSubjects.computeIfAbsent(student, s -> new HashMap<>()).put(subject, null);
    }

    /**
     * Удаление студента из предмета.
     */
    public void removeStudentFromSubject(Student student, Subject subject) {
        subjectStudents.get(subject).remove(student);
        studentSubjects.get(student).remove(subject);
    }

    public void printAllSubjectsWithStudents() {
        subjectStudents.forEach((subject, students) -> {
            System.out.println("Предмет : " + subject);
            for (Student student : students) {
                System.out.println(student);
            }
        });
    }

}
