package faang.school.godbless.students;

import java.util.*;

public class Main {

    private static List<Student> university = new LinkedList<>();

    public static void addStudent(Student student) {
        university.add(student);
    }

    public static void deleteStudent(Student student) {
        if (university.contains(student)) {
            university.remove(student);
        } else {
            System.out.println("Student not in university");
        }
    }

    public static HashMap<String, List<Student>> groupStudents(List<Student> students) {
        HashMap<String, List<Student>> group = new HashMap<>();
        for (Student student : students) {
            String key = student.getFaculty() + " - " + student.getYear();
            if (!group.containsKey(key)) {
                group.put(key, new LinkedList<>(List.of(student)));
            } else {
                group.get(key).add(student);
            }
        }
        return group;
    }

    public static List<Student> getStudentsOfFaculty(String faculty) {
        List<Student> studentsOfFaculty = new LinkedList<>();
        HashMap<String, List<Student>> universityTable = groupStudents(university);
        for (Map.Entry<String, List<Student>> entry : universityTable.entrySet()) {
            if (entry.getKey().startsWith(faculty + " - ")){
                studentsOfFaculty.addAll(entry.getValue());
            }
        }
        return studentsOfFaculty;
    }

    public static List<Student> getStudentsOfYear(int year) {
        List<Student> studentsOfYear = new LinkedList<>();
        HashMap<String, List<Student>> universityTable = groupStudents(university);
        for (Map.Entry<String, List<Student>> entry : universityTable.entrySet()) {
            if (entry.getKey().endsWith(" - " + year)){
                studentsOfYear.addAll(entry.getValue());
            }
        }
        return studentsOfYear;
    }

    public static List<Student> getStudentsOfFacultyAndYear(String faculty, int year) {
        String expectedKey = faculty + " - " + year;
        List<Student> students = new LinkedList<>();
        HashMap<String, List<Student>> universityTable = groupStudents(university);
        for(Map.Entry<String, List<Student>> entry : universityTable.entrySet()) {
            if (entry.getKey().equals(expectedKey)) {
                students.addAll(entry.getValue());
            }
        }
        return students;
    }

    public static void printSortedStudents(){
        HashMap<String, List<Student>> universityTable = groupStudents(university);
        Map<String, List<Student>> sortedStudents = new TreeMap<>(universityTable);
        int count = 0;
        for(Map.Entry<String, List<Student>> entry : sortedStudents.entrySet()) {
            for (Student student : entry.getValue()) {
                count++;
                System.out.println(count + ". " + student);
            }
        }
    }

    public static void main(String[] args) {
        addStudent(new Student("Mike", "Faculty of Law", 2));
        addStudent(new Student("Tom", "Faculty of Mathematics", 1));
        addStudent(new Student("Katy", "Faculty of Economics", 3));
        addStudent(new Student("Sam", "Faculty of Computer Science", 3));
        addStudent(new Student("Emily", "Faculty of Physics", 2));
        addStudent(new Student("John", "Faculty of Social Science", 3));
        addStudent(new Student("Lena", "Faculty of Law", 1));
        addStudent(new Student("Mark", "Faculty of Computer Science", 1));
        addStudent(new Student("Mary", "Faculty of Physics", 4));
        addStudent(new Student("Antony", "Faculty of Mathematics", 4));
        addStudent(new Student("Max", "Faculty of Economics", 3));
        addStudent(new Student("Andy", "Faculty of Computer Science", 3));
        addStudent(new Student("Jack", "Faculty of Physics", 4));
        addStudent(new Student("Jane", "Faculty of Social Science", 3));

        deleteStudent(new Student("Max", "Faculty of Economics", 3));

        printSortedStudents();

        System.out.println(Arrays.toString(getStudentsOfFaculty("Faculty of Law").toArray()));

        System.out.println(Arrays.toString(getStudentsOfYear(2).toArray()));

        System.out.println(Arrays.toString(getStudentsOfFacultyAndYear("Faculty of Computer Science", 3).toArray()));
    }
}
