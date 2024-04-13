package countingSkips;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static Map<String, List<Student>> studentsByFaculty = new HashMap<>();

    public static void main(String[] args) {
        try {
            Student stAnna = new Student("Anna", "IVT", 1);
            Student stKatya = new Student("Ekaterina", "IITIAD", 4);
            Student stLiliya = new Student("Liliya", "IITIAD", 4);
            Student stViktor = new Student("Victor", "IVT", 2);
            Student stPetr = new Student("Petr", "IE", 1);

            List<Student> students = new ArrayList<>(List.of(stAnna, stKatya, stLiliya, stViktor, stPetr));

            System.out.println(getStudents(students));

        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }

        addStudent(null);
        showStudents();

        deleteStudent("Ekaterina", "IITIAD", 4);
        deleteStudent("Petr", "IE", 1);
        showStudents();
    }

    public static Map<String, List<Student>> getStudents(List<Student> students) {
        if (students == null || students.isEmpty()) {
            System.out.println("Входящий список студентов пуст");
            return null;
        }
        for (Student student : students) {
            addStudent(student);
        }

        return studentsByFaculty;
    }

    public static void addStudent(Student student) {
        if (student == null) {
            System.out.println("Не удалось добавить студента");
            return;
        }
        List<Student> students = getStudentsByFaculty(student.getFaculty(), student.getYear());
        if (students != null) {
            students.add(student);
        } else {
            students = new ArrayList<Student>(List.of(student));
        }
        studentsByFaculty.put(student.getFaculty() + " " + student.getYear(), students);
    }

    public static void deleteStudent(String name, String faculty, int year) {
        Student studentForDel = new Student(name, faculty, year);
        List<Student> students = getStudentsByFaculty(faculty, year);
        if (students != null && students.size() > 1) {
            students.remove(studentForDel);
            studentsByFaculty.put(faculty + " " + year, students);
        } else {
            studentsByFaculty.remove(faculty + " " + year);
        }
    }

    public static List<Student> getStudentsByFaculty(String faculty, int year) {
        return studentsByFaculty.get(faculty + " " + year);
    }

    public static void showStudents() {
        for (Map.Entry<String, List<Student>> entry : studentsByFaculty.entrySet()) {
            String facultyYear[] = entry.getKey().split(" ");
            List<String> students = new ArrayList<String>();
            for (Student student : entry.getValue()) {
                students.add(student.getName());
            }
            System.out.println("Студенты факультета " + facultyYear[0] + " курс " + facultyYear[1] + ": " + String.join(", ", students));
        }
    }

}
