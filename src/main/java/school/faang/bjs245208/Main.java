package school.faang.bjs245208;

import static school.faang.bjs245208.SampleData.addStudents;
import static school.faang.bjs245208.SampleData.addSubjects;
import static school.faang.bjs245208.SampleData.addSubjectToStudent;

public class Main {
    public static void main(String[] args) {
        StudentDatabase db = new StudentDatabase();

        addStudents(db);

        db.printAllStudentsWithScores();
        System.out.println();

        addSubjects(db);

        db.printAllSubjectsWithStudents();
        System.out.println();

        addSubjectToStudent(db);

        db.removeStudent("Student3", null);

        db.printAllStudentsWithScores();
    }
}
