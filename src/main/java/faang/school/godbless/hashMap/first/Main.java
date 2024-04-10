package faang.school.godbless.hashMap.first;

import java.util.*;

public class Main {
    private static final List<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        Main main = new Main();
        main.addStudent(new Student("Vadim", "IT", 1));
        main.addStudent(new Student("Igor", "History", 4));
        main.addStudent(new Student("Dmitry", "IT", 1));
        main.addStudent(new Student("Elena", "Philological", 2));
        main.addStudent(new Student("Sergey", "History", 3));
        main.addStudent(new Student("Petr", "IT", 3));
        main.addStudent(new Student("Vladimir", "Philological", 4));
        main.deleteStudent("Elena", "Philological", 2);
        main.writeGroupedStudents(main.groupStudents(students));
    }

    public String generateKey(Student student) {
        String key = student.getFaculty() + " " + student.getYear();
        return key;
    }

    public HashMap<String, List<Student>> groupStudents(List<Student> students) {
        HashMap<String, List<Student>> groupedStudents = new HashMap<>();
        for (Student student : students) {
            if (groupedStudents.containsKey(generateKey(student))) {
                groupedStudents.get(generateKey(student)).add(student);
            } else {
                groupedStudents.put(generateKey(student), new ArrayList<>(Arrays.asList(student)));
            }
        }
        return groupedStudents;
    }

    public void writeGroupedStudents(HashMap<String, List<Student>> groupedStudent) {
        for (Map.Entry entry : groupedStudent.entrySet()) {
            System.out.println(entry);
        }
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void deleteStudent(String name, String faculty, int year) {
        Student student = new Student(name, faculty, year);
        students.remove(student);
    }
}