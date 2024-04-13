package Double_cash;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class Student {
    private int id;
    private String name;
    private Map<Subject, Integer> subjectWithGrade = new HashMap<>();

    public void addToGradesTable(Map<Student, Map<Subject, Integer>> gradesTable) {
        Map<Subject, Integer> gradesTableStudent = new HashMap<>(subjectWithGrade);
        gradesTable.put(this, gradesTableStudent);
    }

    public void putSubjectWithGrade(Subject subject, Integer grade) {
        subjectWithGrade.put(subject, grade);
    }

    public void studentExpulsion(Map<Student, Map<Subject, Integer>> gradesTable) {
        gradesTable.remove(this);
        this.subjectWithGrade = new HashMap<>();
    }

    public static void printGradesTable(Map<Student, Map<Subject, Integer>> gradesTable) {
        for (Map.Entry<Student, Map<Subject, Integer>> student : gradesTable.entrySet()) {
            System.out.println("Student – " + student.getKey().getName());
            System.out.println("Grades:");
            for (Map.Entry<Subject, Integer> grade : student.getValue().entrySet()) {
                System.out.println(grade.getKey().getName() + " – " + grade.getValue());
            }
            System.out.println("––––––––––––––––––––––");

        }
    }

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }
}