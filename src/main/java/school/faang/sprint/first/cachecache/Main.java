package school.faang.sprint.first.cachecache;

import school.faang.sprint.first.cachecache.db.StudentDatabase;

import java.util.Set;

public class Main {
    public static void main(String[] args) {
        StudentDatabase studentDatabase = new StudentDatabase();
        studentDatabase.addStudentWithAttr("Петя", "Математика", 11);
        studentDatabase.addStudentWithAttr("Петя", "Математика", 1);
        studentDatabase.addStudentWithAttr("Петя", "Rtr", 1);
        studentDatabase.addSubjectWithStudents("Математика", Set.of("Петя", "Вася"));

        studentDatabase.printAllStudentsWithAttr();
        studentDatabase.printAllSubjectWithStudents();
        studentDatabase.addStudentWithAttr("Петя", "Rtr", 2);
        studentDatabase.addSubjectForExistStudentWithScore("Пение", "Петя", 2);
        studentDatabase.addStudentToExistSubject("Петя", "Пение");
        studentDatabase.addStudentToExistSubject("Петя", "Чавкание");
        studentDatabase.printAllStudentsWithAttr();
        studentDatabase.printAllSubjectWithStudents();
        studentDatabase.removeStudentFromSubject("Петя", "Чавкание");
        studentDatabase.printAllStudentsWithAttr();
        studentDatabase.printAllSubjectWithStudents();
        studentDatabase.deleteStudent("Петя");
        studentDatabase.printAllStudentsWithAttr();
        studentDatabase.printAllSubjectWithStudents();
    }
}
