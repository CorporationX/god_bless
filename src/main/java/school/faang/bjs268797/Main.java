package school.faang.bjs268797;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        StudentDatabase studentDatabase = new StudentDatabase();
        studentDatabase.addStudentToSubject(new Student("Miras"), new Subject("Math"));
        studentDatabase.addStudentWithGrades(new Student("John"),
                                            Map.of(new Subject("Law"), 5,
                                                    new Subject("Economics"), 5));

        studentDatabase.addSubjectWithStudents(new Subject("English"),
                                            List.of(new Student("Miras"),
                                                    new Student("John")));

        studentDatabase.printAllSubjectsWithStudents();
    }
}
