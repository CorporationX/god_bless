package school.faang.sprint1_2.bjs2_79667;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class StudentDatabase {
    private final Map<Student, Map<Subject, Integer>> studentSubjects = new HashMap<>();
    /*
    В задаче сказано что нужно создать Map<Subject, List<Student>>, но тогда
    будет возможность дублировать студентов в списке предмета, так что использовал Set,
    чтобы не делать проверку на наличие в списке студента перед добавлением.
    Если у студентов будут одинаковые name, то можно будет добавить id.
    Есть какие-то преимущества использовать List?
     */
    private final Map<Subject, Set<Student>> subjectStudents = new HashMap<>();

    public void addStudentWithGrades(Student student, Map<Subject, Integer> grades) {
        studentSubjects.put(student, new HashMap<>(grades));
        grades.forEach((subject, grade) ->
                subjectStudents.computeIfAbsent(subject, s -> new HashSet<>()).add(student)
        );
    }

    public void addSubjectForStudent(Student student, Subject subject, int grade) {
        studentSubjects.putIfAbsent(student, new HashMap<>());
        studentSubjects.get(student).put(subject, grade);
        subjectStudents.computeIfAbsent(subject, s -> new HashSet<>()).add(student);
    }

    public void removeStudent(Student student) {
        Map<Subject, Integer> grades = studentSubjects.remove(student);
        if (grades != null && !grades.isEmpty()) {
            grades.forEach(((subject, integer) -> {
                Set<Student> students = subjectStudents.get(subject);
                if (students != null && !students.isEmpty()) {
                    students.remove(student);
                }
            }));
        }
    }

    public void printAllSubjectsWithStudents() {
        subjectStudents.forEach((subject, students) -> {
            System.out.println("Предмет: " + subject.getName() + ", студенты: ");
            students.forEach(student -> {
                Integer grade = studentSubjects.get(student).get(subject);
                System.out.println(student + ", оценка: " + grade);
            });
            System.out.println("----------------");
        });
    }

    public void addSubjectWithStudents(Subject subject, Set<Student> students) {
        subjectStudents.computeIfAbsent(subject, s -> new HashSet<>()).addAll(students);
        students.forEach(student -> {
            studentSubjects.computeIfAbsent(student, s -> new HashMap<>())
                    .put(subject, null);
        });
    }

    public void addStudentToSubject(Student student, Subject subject) {
        subjectStudents.computeIfAbsent(subject, s -> new HashSet<>())
                .add(student);
        studentSubjects.computeIfAbsent(student, s -> new HashMap<>())
                .put(subject, null);
    }

    public void removeStudentFromSubject(Student student, Subject subject) {
        studentSubjects.computeIfPresent(student, (s, grades) -> {
            grades.remove(subject);
            return grades.isEmpty() ? null : grades;
        });
        subjectStudents.computeIfPresent(subject, (subj, students) -> {
            students.remove(student);
            return students.isEmpty() ? null : students;
        });
    }
}
