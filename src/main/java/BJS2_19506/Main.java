package BJS2_19506;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String NULL_RESULT_MESSAGE = "Student or studentsList can't be null!";

    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();

        studentList.add(new Student("Misha", "Physics", 4));
        studentList.add(new Student("Yana", "English", 4));
        studentList.add(new Student("Olya", "Programming", 3));
        studentList.add(new Student("Stas", "Mathematics", 3));
        studentList.add(new Student("Marina", "Programming", 2));
        studentList.add(new Student("Egor", "English", 4));

        Student testStudent = new Student("Georgiy", "Physics", 4);
        FacultyYearPair testFacultyYearPair = new FacultyYearPair("English", 4);

        //Students Map by faculty and year
        System.out.println(getStudentsGroupedByFacultyYear(studentList));

        //Add Student to List
        addStudent(testStudent, studentList);

        //Remove Student from list
        removeStudent(null, studentList);

        //Get student list using faculty + year pair
        System.out.println(getStudentsByFacultyAndYear(testFacultyYearPair, studentList));

        //Print all students grouped by faculty and year
        printAllStudentsByFacultyAndYear(studentList);
    }

    public static Map<FacultyYearPair, List<Student>> getStudentsGroupedByFacultyYear(List<Student> students) {
        Map<FacultyYearPair, List<Student>> studentMap = new HashMap<>();

        for (Student student : students) {
            FacultyYearPair facultyYearPair = new FacultyYearPair(student.getFaculty(), student.getYear());
            studentMap.computeIfAbsent(facultyYearPair, key -> new ArrayList<>()).add(student);
        }
        return studentMap;
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

        Map<FacultyYearPair, List<Student>> studentsMap = getStudentsGroupedByFacultyYear(students);
        List<Student> studentList = new ArrayList<>();

        if (studentsMap.containsKey(facultyYearPair)) {
            studentList.addAll(studentsMap.get(facultyYearPair));
        }
        return studentList;
    }

    public static void printAllStudentsByFacultyAndYear(List<Student> students) {
        Map<FacultyYearPair, List<Student>> map = getStudentsGroupedByFacultyYear(students);

        for (Map.Entry<FacultyYearPair, List<Student>> entry : map.entrySet()) {
            System.out.println(entry.getKey().getFaculty() + " " + entry.getKey().getYear() + " " + entry.getValue());
        }
    }


}
