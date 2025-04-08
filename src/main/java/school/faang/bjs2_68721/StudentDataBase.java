package school.faang.bjs2_68721;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class StudentDataBase {
    Map<Student, Map<Subject, Integer>> studentSubjects;
    Map<Subject, List<Student>> subjectStudents;

    public void addStudentWithSubject(Student student, Map<Subject, Integer> subjects) {
        if (studentSubjects == null) {
            studentSubjects = new HashMap<>();
        }
        if (subjectStudents == null) {
            subjectStudents = new HashMap<>();
        }
        studentSubjects.put(student, subjects);
        subjects.keySet().forEach(subject -> subjectStudents
                .computeIfAbsent(subject, k -> new ArrayList<>()).add(student));
    }

    public void addSubjectForStudentWithGrade(Subject subject, Student student, Integer grade) {
        studentSubjects.computeIfAbsent(student, k -> new HashMap<>());
        studentSubjects.get(student).put(subject, grade);
        subjectStudents.computeIfAbsent(subject, k -> new ArrayList<>());
        subjectStudents.get(subject).add(student);
    }

    public void removeStudentsFromBothMaps(Student student) {
        boolean removedFromSubjects = studentSubjects.remove(student) != null;
        boolean removedFromAnyList = subjectStudents.values().stream()
                .anyMatch(list -> list.remove(student));

        if (!removedFromSubjects && !removedFromAnyList) {
            throw new NoSuchElementException("Student was not found in any map");
        }
    }

    public void printStudentInfo() {
        studentSubjects.forEach((key, value) -> {
            System.out.println("Student:" + key);
            value.forEach((subject, grade) -> {
                System.out.println("Subject:" + subject);
                System.out.println("Grade:" + grade);
                System.out.println("-----------------------");
            });
        });
    }

    public void addSubjectWithStudents(Subject subject, List<Student> students) {
        if (studentSubjects == null) {
            studentSubjects = new HashMap<>();
        }
        if (subjectStudents == null) {
            subjectStudents = new HashMap<>();
        }
        subjectStudents.putIfAbsent(subject, students);

        students.forEach(student -> {
            studentSubjects.putIfAbsent(student, new HashMap<>());
            studentSubjects.get(student).putIfAbsent(subject, null);

        });
    }

    public void addStudentToSubject(Student student, Subject subject) {
        if (!(studentSubjects.get(student) == null) || !(subjectStudents.get(subject) == null)) {
            subjectStudents.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);
            studentSubjects.computeIfAbsent(student, k -> new HashMap<>()).put(subject, null);
        }


    }

    public void removeStudentFromSubject(Student student, Subject subject) {
        if (studentSubjects != null && subjectStudents != null) {
            if (studentSubjects.containsKey(student)) {
                studentSubjects.get(student).remove(subject);
            }
            if (subjectStudents.containsKey(subject)) {
                subjectStudents.get(subject).remove(student);
            }
        }
    }
}

/*
Я думаю, что если дуну на этот код, он сразу же развалится. Очень долго рожал все конструкции.
На будущее: ОБАТИТЬ ОСОБОЕ ВНИМАНИЕ НА computeIfAbsent! Разобраться, почему function k в методе оптимальнее, чем
просто putIfAbsent
 */



