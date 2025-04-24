package school.faang.stream2.electronicdiary;

import java.io.File;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        File studentsFile = new File("C:/Users/Aleksandr/IdeaProjects/students_test_data.json");
        List<Student> students = Util.parseStudentsFromFile(studentsFile);
        System.out.println(School.calculateAverage(students));
        System.out.println(School.calculateMostDifficultSubject(students));
        System.out.println(School.calculateResultByStudent(students, "Мария", "Волкова"));
        Util.printTableInConsole(students);
    }
}
