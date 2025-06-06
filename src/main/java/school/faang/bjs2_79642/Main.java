package school.faang.bjs2_79642;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class Main {
    private static Subject physics = new Subject("Physics");
    private static Subject chemistry = new Subject("Chemistry");
    private static Subject biology = new Subject("Biology");
    private static Subject literature = new Subject("Literature");
    private static Subject math = new Subject("Mathematics");

    private static Student anna = new Student("Anna");
    private static Student ivan = new Student("Ivan");

    public static void main(String[] args) {
        Map<Subject, Integer> annaSubjects = new HashMap<>();
        annaSubjects.put(physics, 5);
        annaSubjects.put(chemistry, 4);

        Map<Subject, Integer> ivanSubjects = new HashMap<>();
        ivanSubjects.put(physics, 5);

        StudentDatabase studentDatabase = new StudentDatabase();

        studentDatabase.addStudentWithSubjects(anna, annaSubjects);
        studentDatabase.addStudentWithSubjects(anna, annaSubjects);
        log.info("Добавили студента {} с предметами {}", anna.name(), annaSubjects);
        studentDatabase.addStudentWithSubjects(ivan, ivanSubjects);
        log.info("Добавили студента {} с предметами {}", ivan.name(), ivanSubjects);

        studentDatabase.addSubjectToStudent(anna, biology, 5);
        log.info("Добавили новый предмет {} для {}", biology.name(), anna.name());
        studentDatabase.addSubjectToStudent(ivan, literature, 3);
        log.info("Добавили новый предмет {} для {}", literature.name(), ivan.name());

        studentDatabase.printAllSubjectsWithStudentsAndGrades();

        studentDatabase.addSubjectWithStudents(math, List.of(anna, ivan));
        log.info("Добавили предмет {} со списком студентов {}, {}", math.name(), ivan.name(), anna.name());

        studentDatabase.addStudentToSubject(ivan, chemistry);
        log.info("Добавили {} к предмету {}", ivan.name(), chemistry.name());

        studentDatabase.removeStudent(anna);
        log.info("Удалили {}", anna.name());

        studentDatabase.removeStudentFromSubject(ivan, chemistry);
        log.info("Удалили предмет {} у {}", chemistry.name(), ivan.name());

        studentDatabase.printAllSubjectsWithStudents();
    }
}
