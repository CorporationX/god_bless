package school.faang.task57079.student;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class StudentDatabase {
    private final Map<Student, Map<Subject, Integer>> studentSubjects = new HashMap<>();
    private final Map<Subject, List<Student>> subjectStudents = new HashMap<>();
    Logger logger = LoggerFactory.getLogger(StudentDatabase.class);

    public void addStudentWithSubject(@NonNull Student student, @NonNull Map<Subject, Integer> subjects) {
        studentSubjects.putIfAbsent(student, subjects);
        for (Subject subject : subjectStudents.keySet()) {
            subjectStudents.putIfAbsent(subject, new ArrayList<>());
            subjectStudents.get(subject).add(student);
        }
        logger.info("addStudentWithSubject is success");
    }

    public void addSubjectWithStudent(@NonNull Subject subject, @NonNull Student student, int score) {
        studentSubjects.putIfAbsent(student, new HashMap<>());
        studentSubjects.get(student).put(subject, score);
        subjectStudents.putIfAbsent(subject, new ArrayList<>());
        subjectStudents.get(subject).add(student);
        logger.info("addSubjectWithStudent is success");
    }

    public void deleteStudent(@NonNull Student student) {
        studentSubjects.remove(student);
        for (Subject subject : subjectStudents.keySet()) {
            List<Student> students = subjectStudents.get(subject);
            students.remove(student);
        }
        logger.info("deleteStudent is success");
    }

    public void printAllStudentWithScores() {
        for (Map.Entry<Student, Map<Subject, Integer>> entry : studentSubjects.entrySet()) {
            System.out.printf("Студент: %s\n", entry.getKey().toString());
            for (Map.Entry<Subject, Integer> subjectsWithScore : entry.getValue().entrySet()) {
                System.out.printf("Предмет: %s, оценка: %d\n",
                        subjectsWithScore.getKey().toString(), subjectsWithScore.getValue());
            }
            System.out.println();
        }
        logger.info("printAllStudentWithScores is success");
    }

    public void addSubjectForStudents(@NonNull Subject subject, @NonNull List<Student> students) {
        subjectStudents.putIfAbsent(subject, students);
        for (Student student : students) {
            studentSubjects.putIfAbsent(student, new HashMap<>());
            studentSubjects.get(student).put(subject, null);
        }
        logger.info("addSubjectForStudents is success");
    }

    public void addStudentToSubject(@NonNull Student student, @NonNull Subject subject) {
        subjectStudents.putIfAbsent(subject, new ArrayList<>());
        subjectStudents.get(subject).add(student);
        studentSubjects.putIfAbsent(student, new HashMap<>());
        studentSubjects.get(student).put(subject, null);
        logger.info("addStudentToSubject is success");
    }

    public void deleteStudentFromSubject(@NonNull Student student, @NonNull Subject subject) {
        Map<Subject, Integer> subjectWithScores = studentSubjects.get(student);
        if (subjectWithScores != null) {
            studentSubjects.remove(student);
        } else {
            logger.warn("subjectWithScores is null");
        }
        List<Student> students = subjectStudents.get(subject);
        if (students != null) {
            students.remove(student);
        } else {
            logger.warn("students is null");
        }
        logger.info("deleteStudentFromSubject is success");
    }

    public void printAllSubjectsAndStudents() {
        for (Map.Entry<Subject, List<Student>> entry : subjectStudents.entrySet()) {
            System.out.printf("Предмет: %s\n", entry.getKey().toString());
            for (Student student : entry.getValue()) {
                System.out.printf("Студент: %s", student.toString());
            }
            System.out.println();
        }
        logger.info("printAllSubjectsAndStudents is success");
    }
}
