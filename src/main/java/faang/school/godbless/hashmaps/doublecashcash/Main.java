package faang.school.godbless.hashmaps.doublecashcash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    public static final Map<Student, Map<Subject, Integer>> studentSubjectsEstimates = new HashMap<>();
    public static final Map<Subject, Set<Student>> subjectStudents = new HashMap<>();

    public static void main(String[] args) {
        Map<Subject, Integer> subjectEstimateOne = new HashMap<>();
        subjectEstimateOne.put(new Subject(1, "Математика"), 5);
        subjectEstimateOne.put(new Subject(2, "Программирование"), 5);
        subjectEstimateOne.put(new Subject(3, "Русский язык"), 4);
        addStudentSubjectsEstimates(new Student(1, "Петя"), subjectEstimateOne);
        Map<Subject, Integer> subjectEstimateTwo = new HashMap<>();
        subjectEstimateTwo.put(new Subject(1, "Математика"), 4);
        subjectEstimateTwo.put(new Subject(2, "Программирование"), 4);
        addStudentSubjectsEstimates(new Student(2, "Саша"), subjectEstimateTwo);
        showStudentSubjectsEstimates();

        addSubjectEstimateForStudent(new Student(2, "Саша"), new HashMap<>(
                Map.of(new Subject(3, "Русский язык"), 5))
        );
        showStudentSubjectsEstimates();

        removeStudentSubjectsEstimates(new Student(1, "Петя"));
        showStudentSubjectsEstimates();

        addSubjectStudents(
                new Subject(4, "Физкультура"),new HashSet<>(Set.of(new Student(3, "Ваня")))
        );
        showSubjectsStudents();

        addStudentForSubject(new Subject(4, "Физкультура"), new Student(2, "Саша"));
        showSubjectsStudents();

        removeStudentFromSubject(new Subject(3, "Русский язык"), new Student(2, "Саша"));
        showSubjectsStudents();
    }

    public static void addStudentSubjectsEstimates(Student student, Map<Subject, Integer> subjectsEstimates) {
        studentSubjectsEstimates.put(student, subjectsEstimates);
        for (Map.Entry<Subject, Integer> subjectEstimate : subjectsEstimates.entrySet()) {
            try {
                addStudentForSubject(subjectEstimate.getKey(), student);
            } catch (IllegalArgumentException e) {
                addSubjectStudents(subjectEstimate.getKey(), new HashSet<>(Set.of(student)));
            }
        }
    }

    public static void addSubjectEstimateForStudent(Student student, Map<Subject, Integer> subjectEstimate) {
        Map<Subject, Integer> subjectEstimateForStudent = studentSubjectsEstimates.get(student);
        if(subjectEstimateForStudent != null) {
            subjectEstimateForStudent.putAll(subjectEstimate);
            for (Map.Entry<Subject, Integer> subjectEstimateEntry : subjectEstimate.entrySet()) {
                try {
                    addStudentForSubject(subjectEstimateEntry.getKey(), student);
                } catch (IllegalArgumentException e) {
                    addSubjectStudents(subjectEstimateEntry.getKey(), new HashSet<>(Set.of(student)));
                }
            }
        } else {
            System.out.println("Студент - " + student + " не существует в словаре, чтобы добавить нового студента" +
                    " воспользуйтесь методом addStudentSubjectsEstimates()"
            );
        }
    }

    public static void removeStudentSubjectsEstimates(Student student) {
        Map<Subject, Integer> subjectEstimate = studentSubjectsEstimates.remove(student);
        for (Map.Entry<Subject, Integer> subjectEstimateEntry : subjectEstimate.entrySet()) {
            removeStudentFromSubject(subjectEstimateEntry.getKey(), student);
        }
    }

    public static void showStudentSubjectsEstimates() {
        for (Map.Entry<Student, Map<Subject, Integer>> studentSubjectsEstimate
                : studentSubjectsEstimates.entrySet()) {
            System.out.println("Студент: " + studentSubjectsEstimate.getKey());
            for (Map.Entry<Subject, Integer> subjectEstimate : studentSubjectsEstimate.getValue().entrySet()) {
                System.out.println(
                        "\t" + "Предмет: " + subjectEstimate.getKey() + ", оценка - " + subjectEstimate.getValue()
                );
            }
        }
        System.out.println();
    }

    public static void addSubjectStudents(Subject subject, Set<Student> students) {
        subjectStudents.put(subject, students);
    }

    public static void addStudentForSubject (Subject subject, Student student) throws IllegalArgumentException {
        Set<Student> students = subjectStudents.get(subject);
        if (students != null) {
            students.add(student);
        } else {
          throw new IllegalArgumentException("Предмет - " + subject + "не существует в словаре,  чтобы добавить новый предмет" +
                    "воспользуйтесь методом addSubjectStudents()"
          );
        }
    }

    public static void removeStudentFromSubject(Subject subject, Student student) {
        Set<Student> students = subjectStudents.get(subject);
        if (students != null) {
            students.remove(student);
        } else {
            System.out.println("Переданного предмета не существует в словаре, удаление не было произведено");
        }
    }

    public static void showSubjectsStudents() {
        for (Map.Entry<Subject, Set<Student>> subjectStudents: subjectStudents.entrySet()) {
            System.out.println("Предмет - " + subjectStudents.getKey());
            for (Student student : subjectStudents.getValue()) {
                System.out.println("\t" + student);
            }
        }
        System.out.println();
    }
}
