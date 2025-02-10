package school.faang.doublecache;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        StudentDatabase db = new StudentDatabase();
        Student student1 = new Student("Brice");
        Student student2 = new Student("Alice");
        Student student3 = new Student("Bob");
        Subject subject1 = new Subject("Programming");
        Subject subject2 = new Subject("Mathematics");
        Subject subject3 = new Subject("Physics");
        Subject subject4 = new Subject("Biology");
        Subject subject5 = new Subject("Cybernetics");
        db.addStudentWithGrades(student1, Map.of(subject1, 4, subject2, 5));
//        db.addStudentWithGrades(student2, Map.of(subject2, 3, subject3, 4));
//        db.addStudentWithGrades(student3, Map.of(subject4, 5, subject5, 5));
//        db.printAllStudentsWithSubjectsAndGrades();
//        db.addSubjectForStudent(student3, subject1, 3);
//        db.removeStudent(student1);
//        db.printAllStudentsWithSubjectsAndGrades();
//        db.addSubjectWithStudents(subject4, List.of(student1, student3));
//        db.printAllStudentsWithSubjectsAndGrades();
        //db.addStudentToSubject();
    }
}
