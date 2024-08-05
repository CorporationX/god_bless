package BJS2_19506;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        List<Student> studentList = new ArrayList<>();

        studentList.add(new Student("Misha", "Physics", 4));
        studentList.add(new Student("Yana", "English", 4));
        studentList.add(new Student("Olya", "Programming", 3));
        studentList.add(new Student("Stas", "Mathematics", 3));
        studentList.add(new Student("Marina", "Programming", 2));
        studentList.add(new Student("Egor", "English", 4));

        Student testStudent = new Student("Georgiy", "Physics", 4);
        Pair testPair = new Pair("English", 4);


        //Students Map
        System.out.println(getStudentsMap(studentList));

        //Add Student to List
        addStudent(testStudent, studentList);

        //Remove Student from list
        removeStudent(testStudent, studentList);

        //Get student list using faculty + year pair
        System.out.println(getSpecificStudents(testPair, studentList));

        //Get all students grouped by faculty and year
        getAllStudentsByFacultyAndYear(studentList);
    }

    public static Map<Pair, List<Student>> getStudentsMap(List<Student> students) {
        Map<Pair, List<Student>> studentMap = new HashMap<>();

        for (Student student : students) {
            Pair pair = new Pair(student.getFaculty(), student.getYear());
            if (!studentMap.containsKey(pair)) {
                studentMap.put(pair, new ArrayList<>());
                studentMap.get(pair).add(student);
            } else {
                studentMap.get(pair).add(student);
            }
        }
        return studentMap;
    }

    public static void addStudent(Student student, List<Student> students) {
        students.add(student);
        System.out.println("Student " + student.getName() + " was successfully added!");
    }

    public static void removeStudent(Student student, List<Student> students) {
        students.remove(student);
        System.out.println("Student " + student.getName() + " was successfully removed!");
    }

    public static List<Student> getSpecificStudents(Pair pair, List<Student> students) {

        Map<Pair, List<Student>> studentsMap = getStudentsMap(students);
        List<Student> studentList = new ArrayList<>();

        if (studentsMap.containsKey(pair)) {
            studentList.addAll(studentsMap.get(pair));
        }

        return studentList;
    }

    public static void getAllStudentsByFacultyAndYear(List<Student> students) {
        Map<Pair, List<Student>> map = getStudentsMap(students);

        for (Map.Entry<Pair, List<Student>> entry : map.entrySet()) {
            System.out.println(entry.getKey().getFirst() + " " + entry.getKey().getSecond() + " " + entry.getValue());
        }
    }


}
