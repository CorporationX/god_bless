package CountingAbsenteeism;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Mark", "Computer Science", 3));
        students.add(new Student("Dima", "System design", 2));
        students.add(new Student("Roma", "Mathematics", 1));
        students.add(new Student("Bill", "Computer Science", 3));
        students.add(new Student("Lora", "System design", 5));

        printInfo(students);
        addStudent(new Student("Sasha", "System design", 2), students);
        addStudent(new Student("Albert", "Phisica", 4), students);
        printInfo(students);
        removeStudent("Roma", "Mathematics", 1, students);
        printInfo(students);
        searchStudent("Mathematics", 1, students);
        searchStudent("Computer Science", 3, students);
    }

    public static HashMap<String, List<Student>> getListStudents(List<Student> students) {
        HashMap<String, List<Student>> facultyStudents = new HashMap<>();
        for (Student student : students) {
            String facultyAndYear = student.getFaculty() + ", " + student.getYear();
            if (!facultyStudents.containsKey(facultyAndYear)) {
                facultyStudents.put(facultyAndYear, new ArrayList<>());
            }
            facultyStudents.get(facultyAndYear).add(student);
        }
        return facultyStudents;
    }

    public static void addStudent(Student student, List<Student> students) {
        String facultyAndYear = student.getFaculty() + ", " + student.getYear();
        if (students.contains(student)) {
            System.out.println("Такой студент уже содержится в списке.");
            return;
        }
        students.add(student);

        if (!getListStudents(students).containsKey(facultyAndYear)) {
            getListStudents(students).put(facultyAndYear, new ArrayList<>());
            getListStudents(students).get(facultyAndYear).add(student);
        }
        getListStudents(students).put(facultyAndYear, students);
    }

    public static void removeStudent(String name, String faculty, int year, List<Student> students) {
        Student removeStudent = new Student(name, faculty, year);
        if (students.contains(removeStudent)) {
            students.remove(removeStudent);
            String facultyAndYear = removeStudent.getFaculty() + ", " + removeStudent.getYear();
            if (getListStudents(students).containsKey(facultyAndYear)) {
                getListStudents(students).get(facultyAndYear).remove(removeStudent);
            }
            System.out.println("Студент удален.");
        } else {
            System.out.println("Такого студента в списке нет.");
        }
    }

    public static void searchStudent(String faculty, int year, List<Student> students) {
        String facultyAndYear = faculty + ", " + year;
        if (getListStudents(students).containsKey(facultyAndYear)) {
            System.out.println("Студент(ы) найден(ы) - " + getListStudents(students).get(facultyAndYear));
        } else {
            System.out.println("Студент не найден.");
        }
    }

    public static void printInfo(List<Student> students) {
        System.out.println("--------------------");
        for (Map.Entry<String, List<Student>> entry : getListStudents(students).entrySet()) {
            System.out.println(entry.getKey() + " --> " + entry.getValue());
        }
    }
}
