package school.faang.task133;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    private static final List<Student> students = new ArrayList<>();

    static {
        Student student1 = new Student("Ilya", "Гриффиндор", 4);
        Student student2 = new Student("Artem", "Слизерин", 4);
        Student student3 = new Student("Dima", "Слизерин", 4);
        Student student4 = new Student("Svyatoslav", "Пуффендуй", 4);
        Student student5 = new Student("ivan", "Слизерин", 3);

        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);
    }

    public HashMap<Cohort, List<Student>> createCohort(List<Student> students) {
        HashMap<Cohort, List<Student>> result = new HashMap<>();
        for (Student student : students) {
            result.computeIfAbsent(Cohort.createNewCohort(student), k -> new ArrayList<>()).add(student);
        }
        return result;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(String name, String faculty, int year) {
        Student student = new Student(name, faculty, year);
        students.remove(student);
    }

    public List<Student> findStudentsByFacultyAndYear(String faculty, int year) {
        List<Student> result = new ArrayList<>();
        for (Student student : students) {
            if (student.getYear() == year && student.getFaculty().equals(faculty)) {
                result.add(student);
            }
        }
        return result;
    }

    public void printAllGroupedStudents() {
        HashMap<Cohort, List<Student>> allStudentsGrouped = createCohort(students);
        for (Map.Entry<Cohort, List<Student>> entry : allStudentsGrouped.entrySet()) {
            for (Student student : entry.getValue()) {
                System.out.println(entry.getKey() + " " + student);
            }
            System.out.println("================================================================");
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.printAllGroupedStudents();
        System.out.println();

        Student student = new Student("Вася", "Пуффендуй", 4);
        main.addStudent(student);
        main.printAllGroupedStudents();
        System.out.println();

        main.removeStudent("Ilya", "Гриффиндор", 4);
        main.printAllGroupedStudents();
        System.out.println();

        List<Student> studentList = main.findStudentsByFacultyAndYear("Пуффендуй", 4);
        for (Student student1 : studentList) {
            System.out.println(student1);
        }
    }
}
