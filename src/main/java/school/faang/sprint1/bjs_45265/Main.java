package school.faang.sprint1.bjs_45265;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        StudentDatabase studDataBase = new StudentDatabase();

        List<Student> students = DataGenerationForTest.generateStudentsData(7);
        List<Subject> subjects = DataGenerationForTest.generateSubjectsData(4);
        Map<Subject, Integer> subjectMap = DataGenerationForTest.generateSubjectMap(subjects);

        studDataBase.addStudentWithSubjectsAndGrades(students.get(1), subjectMap);
        studDataBase.printAllStudents();
        System.out.println("--------------------------");
        studDataBase.addNewSubjectForStudent(students.get(2), subjects.get(3), 5);
        studDataBase.printAllStudents();
        System.out.println("--------------------------");
        studDataBase.addNewSubjectRecord(subjects.get(2), students);
        studDataBase.printAllStudents();
        System.out.println("--------------------------");
        studDataBase.addStudentEnrollment(students.get(5), subjects.get(1));
        studDataBase.printAllStudents();
        System.out.println("--------------------------");
        studDataBase.deleteStudentFromSubjectList(students.get(2), subjects.get(3));
        System.out.println("#######");
        studDataBase.printAllSubjects();
        System.out.println("#######");
        studDataBase.deleteStudentRecords(students.get(1));
        studDataBase.printAllStudents();
    }
}
