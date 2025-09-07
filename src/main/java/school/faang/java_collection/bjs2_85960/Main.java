package school.faang.java_collection.bjs2_85960;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        StudentDatabase students = new StudentDatabase();

        Student igor = new Student("Игорь");
        Student roman = new Student("Роман");
        Student alla = new Student("Алла");
        Student ivan = new Student("Иван");
        Student ivan2 = new Student("Иван");

        Subject history = new Subject("История");
        Subject informatics = new Subject("Информатика");
        Subject physics = new Subject("Физика");
        Subject chemistry = new Subject("Химия");
        Subject algorithms = new Subject("Алгоритмы");

        Map<Subject, Integer> allaGrades = Map.of(informatics, 4, physics, 4, chemistry, 4);
        Map<Subject, Integer> ivanGrades = Map.of(history, 5, informatics, 5, physics, 5, chemistry, 5);
        List<Student> studentsStudyingAgorithms = List.of(igor, roman, ivan, alla);

        students.addSubjectForStudent(igor, history, 4);
        students.addSubjectForStudent(igor, informatics, 5);
        students.addSubjectForStudent(igor, chemistry, 4);
        students.addSubjectForStudent(roman, history, 3);
        students.addSubjectForStudent(roman, chemistry, 4);

        students.addStudentWithGrades(alla, allaGrades);
        students.addStudentWithGrades(ivan, ivanGrades);

        //students.addSubjectWithStudents(algorithms, studentsStudyingAgorithms);
        students.addStudentToSubject(roman, informatics);

        students.removeStudentFromSubject(roman, history);
        students.removeStudent(igor);
        students.removeStudent(ivan2);

        students.printAllStudentsWithGrades();
        students.printAllSubjectsWithStudents();
    }
}
