package BJS2_19506;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String NULL_RESULT_MESSAGE = "Student or studentsList can't be null!";

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        students.add(new Student("Misha", "Physics", 4));
        students.add(new Student("Yana", "English", 4));
        students.add(new Student("Olya", "Programming", 3));
        students.add(new Student("Stas", "Mathematics", 3));
        students.add(new Student("Marina", "Programming", 2));
        students.add(new Student("Egor", "English", 4));

        Student testStudent = new Student("Georgiy", "Physics", 4);
        FacultyYearPair testFacultyYearPair = new FacultyYearPair("English", 4);

        //Students by faculty and year
        System.out.println(getStudentsGroupedByFacultyYear(students));

        //Add Student to List
        addStudent(testStudent, students);

        //Remove Student from list
        removeStudent(null, students);

        //Get student list using faculty + year pair
        System.out.println(getStudentsByFacultyAndYear(testFacultyYearPair, students));

        //Print all students grouped by faculty and year
        printAllStudentsByFacultyAndYear(students);
    }

    public static Map<FacultyYearPair, List<Student>> getStudentsGroupedByFacultyYear(List<Student> students) {
        Map<FacultyYearPair, List<Student>> studentsByFacultyYear = new HashMap<>();

        for (Student student : students) {
            FacultyYearPair facultyYearPair = new FacultyYearPair(student.getFaculty(), student.getYear());
            studentsByFacultyYear.computeIfAbsent(facultyYearPair, key -> new ArrayList<>()).add(student);
        }
        return studentsByFacultyYear;
    }

    public static void addStudent(Student student, List<Student> students) {
        try {
            students.add(student);
            System.out.println("Student " + student.getName() + " was successfully added!");
        } catch (NullPointerException e) {
            System.out.println(NULL_RESULT_MESSAGE);
        }
    }

    public static void removeStudent(Student student, List<Student> students) {
        try {
            students.remove(student);
            System.out.println("Student " + student.getName() + " was successfully removed!");
        } catch (NullPointerException e) {
            System.out.println(NULL_RESULT_MESSAGE);
        }
    }

    public static List<Student> getStudentsByFacultyAndYear(FacultyYearPair facultyYearPair, List<Student> students) {

        Map<FacultyYearPair, List<Student>> studentsByFacultyYear = getStudentsGroupedByFacultyYear(students);
        List<Student> groupedStudents = new ArrayList<>();

        if (studentsByFacultyYear.containsKey(facultyYearPair)) {
            groupedStudents.addAll(studentsByFacultyYear.get(facultyYearPair));
        }
        return groupedStudents;
    }

    public static void printAllStudentsByFacultyAndYear(List<Student> students) {
        Map<FacultyYearPair, List<Student>> studentsByFacultyYear = getStudentsGroupedByFacultyYear(students);

        for (Map.Entry<FacultyYearPair, List<Student>> entry : studentsByFacultyYear.entrySet()) {
            System.out.println(entry.getKey().getFaculty() + " " + entry.getKey().getYear() + " " + entry.getValue());
        }
    }


}
