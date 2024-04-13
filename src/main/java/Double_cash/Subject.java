package Double_cash;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Getter
@ToString
public class Subject {
    private final int id;
    private final String name;
    private final List<Student> students = new ArrayList<>();

    public void addToStudentsTable(Map<Subject, List<Student>> studentsTable) {
        List<Student> tableStudents = new ArrayList<>(students);
        studentsTable.put(this, tableStudents);
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void deleteStudentFromSubject(Student student, Map<Subject, List<Student>> studentsTable) {
        if (students.contains(student)) {
            students.remove(student);
            List<Student> studentsList = studentsTable.get(this);
            if (studentsList != null) {
                studentsList.remove(student);
            }
        }
    }

    public static void printStudentsTable(Map<Subject, List<Student>> studentsTable) {
        for (Map.Entry<Subject, List<Student>> subject : studentsTable.entrySet()) {
            System.out.println("Subject – " + subject.getKey().getName());
            System.out.println("Students:");
            for (Student student : subject.getValue()) {
                System.out.println(student.getName());
            }
            System.out.println("––––––––––––––––––––––");

        }
    }

    public Subject(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
