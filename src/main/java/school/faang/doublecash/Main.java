package school.faang.doublecash;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Slf4j
public class Main {
    public static void main(String[] args) {
        StudentDatabase studentDatabase = new StudentDatabase();
        try {
            studentDatabase.addStudentWithGrades("Игорь", new HashMap<>() {{
                        put(new Subject("Химия"), 4);
                        put(new Subject("Математика"), 5);
                        put(new Subject("Физика"), 5);
                    }}
            );
            studentDatabase.addStudentWithGrades("Ваня", new HashMap<>() {{
                        put(new Subject("География"), 4);
                        put(new Subject("Математика"), 4);
                        put(new Subject("Физика"), 4);
                    }}
            );
            studentDatabase.addStudentWithGrades("Катя", new HashMap<>() {{
                        put(new Subject("Литература"), 5);
                        put(new Subject("Математика"), 4);
                        put(new Subject("Русский"), 5);
                    }}
            );
            studentDatabase.printAllStudents();

            studentDatabase.addSubjectForStudent("Литература", "Ваня", 3);
            studentDatabase.addSubjectForStudent("Физика", "Катя", 3);
            studentDatabase.addStudentToSubject("Алексей", "Физика", 5);

            studentDatabase.printAllStudents();

            System.out.println(studentDatabase.removeStudent("Катя"));
            System.out.println(studentDatabase.removeStudentFromSubject("Ваня", "География"));
            studentDatabase.addSubjectWithStudents(new Subject("Химия"),
                    new ArrayList<>(List.of(new Student("Катя"), new Student("Алексей"))));
        } catch (IllegalArgumentException e) {
            log.info(e.getMessage());
        }
        studentDatabase.printAllStudents();
        studentDatabase.printAllSubjects();
    }
}