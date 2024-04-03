package faang.school.godbless.javaHashMap.proguly;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private List<Student> studentBase;

    public Main() {
        this.studentBase = new ArrayList<>();

        studentBase.add(new Student("Oleg", "IT", 3));
        studentBase.add(new Student("Vasya", "IT", 3));
        studentBase.add(new Student("Yarik", "IT", 4));
        studentBase.add(new Student("Ruslan", "Economics", 1));
        studentBase.add(new Student("Alex", "Economics", 1));
        studentBase.add(new Student("Danil", "Phys-tech", 4));
        studentBase.add(new Student("Anna", "Pharma", 4));
    }

    public static void main(String[] args) {
        Main studentManager = new Main();

        System.out.println("StudentManager test.\n");

        System.out.println("Student base at start point:");
        studentManager.printGroupedStudents();


        System.out.println("\nAdding new student:");
        studentManager.addNewStudent("Denis", "IT", 4);

        System.out.println("Student base after that:");
        studentManager.printGroupedStudents();


        System.out.println("\nRemoving a student (Ruslan):");
        studentManager.removeStudent("Ruslan", "Economics", 1);

        System.out.println("Student base after that:");
        studentManager.printGroupedStudents();


        System.out.println("\nStudents of IT faculty 4th year:");
        studentManager.getStudentsByFacultyAndYear("IT", 4).forEach(System.out::println);


        System.out.println("Done.");
    }

    public Map<StudentKey, List<Student>> groupStudents(List<Student> studentList) {
        Map<StudentKey, List<Student>> groupedStudents = new HashMap<>();

        for(Student student : studentList) {
            StudentKey currentKey = new StudentKey(student.getFaculty(), student.getYear());
            groupedStudents.computeIfAbsent(currentKey, key -> new ArrayList<>()).add(student);
        }

        return groupedStudents;
    }

    public void addNewStudent(String name, String faculty, int year) {
        this.studentBase.add(new Student(name, faculty, year));
    }

    public void removeStudent(String name, String faculty, int year) {
        Student studentToBeRemoved = getStudentFromBase(name, faculty, year);

        if(studentToBeRemoved == null) {
            System.out.println("No such student in the StudentBase!");

            return;
        }

        this.studentBase.remove(studentToBeRemoved);
    }

    public List<Student> getStudentsByFacultyAndYear(String faculty, int year) {
        return groupStudents(this.studentBase).getOrDefault(new StudentKey(faculty, year), null);
    }

    public void printGroupedStudents() {
        groupStudents(studentBase).entrySet().forEach(System.out::println);
    }

    private Student getStudentFromBase(String name, String faculty, int year) {
        for(Student student : this.studentBase) {
            if(student.equals(new Student(name, faculty, year))) {
                return student;
            }
        }
        return null;
    }
}
